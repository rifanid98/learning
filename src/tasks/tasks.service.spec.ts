import {
  ArgumentMetadata,
  NotFoundException,
  Provider,
  ValidationPipe,
} from '@nestjs/common';
import { Test } from '@nestjs/testing';
import { User } from 'src/auth/users.entity';
import { TaskDto } from './dto/task.dto';
import { Task } from './tasks.entity';
import { TasksRepository } from './tasks.repository';
import { TasksService } from './tasks.service';
import { Status } from './types/tasks-status';

describe('TaskService', () => {
  let tasksService: TasksService;
  let tasksRepository;

  const mockUser: User = {
    id: 'id',
    username: 'username',
    password: 'password',
    tasks: [],
  };

  const mockTask: Task = {
    id: 'id',
    title: 'title',
    description: 'description',
    status: Status.OPEN,
    user: mockUser,
  };

  const mockTasks: Task[] = [mockTask, mockTask];

  const mockTasksRepository = () => ({
    getTasks: jest.fn(),
    findOne: jest.fn(),
    createTask: jest.fn(),
    delete: jest.fn(),
    save: jest.fn(),
  });

  const MockTasksRepository: Provider = {
    provide: TasksRepository,
    useFactory: mockTasksRepository,
  };

  beforeEach(async () => {
    const module = await Test.createTestingModule({
      providers: [TasksService, MockTasksRepository],
    }).compile();

    tasksService = await module.get(TasksService);
    tasksRepository = await module.get(TasksRepository);
  });

  describe('getTasks', () => {
    it('should calls TasksRepository.getTasks and returns the result', async () => {
      tasksRepository.getTasks.mockResolvedValue(mockTasks);
      const tasks = await tasksService.getTasks(null, mockUser);
      expect(tasksRepository.getTasks).toHaveBeenCalled();
      expect(tasks).toHaveLength(mockTasks.length);
    });
  });

  describe('getTaskById', () => {
    it('should calls TasksRepository.findOne and returns the result', async () => {
      tasksRepository.findOne.mockResolvedValue(mockTask);
      const task = await tasksService.getTaskById(null, mockUser);
      expect(tasksRepository.findOne).toHaveBeenCalled();
      expect(task).toEqual(mockTask);
    });

    it('should calls TasksRepository.findOne and handles an error', () => {
      tasksRepository.findOne.mockResolvedValue(null);
      expect(tasksService.getTaskById(null, mockUser)).rejects.toThrow(
        NotFoundException,
      );
    });
  });

  describe('createTask', () => {
    it('should calls TasksRepository.createTask() and returns the result', async () => {
      expect(tasksRepository.createTask).not.toHaveBeenCalled();
      const task: TaskDto = {
        title: mockTask.title,
        description: mockTask.description,
        status: mockTask.status,
      };
      tasksRepository.createTask.mockResolvedValue(task);
      const result = await tasksService.createTask(task, mockUser);
      expect(tasksRepository.createTask).toHaveBeenCalled();
      expect(result).toEqual(task);
    });

    it('should validate incoming data', async () => {
      let validationPipe: ValidationPipe = new ValidationPipe();
      const metadata: ArgumentMetadata = {
        type: 'body',
        metatype: TaskDto,
        data: '',
      };
      const task: TaskDto = {
        title: '',
        description: 'description',
        status: Status.OPEN,
      };
      await validationPipe.transform(task, metadata).catch((err) => {
        expect(err.toString()).toEqual('Error: Bad Request Exception');
      });
    });
  });

  describe('deleteTask', () => {
    it('should calls TasksRepository.delete() to delete a task', async () => {
      tasksRepository.delete.mockResolvedValue({ affected: 1 });
      expect(tasksRepository.delete).not.toHaveBeenCalled();
      await tasksService.deleteTask('1', mockUser);
      expect(tasksRepository.delete).toHaveBeenCalled();
    });

    it('should calls TasksRepository.delete() and handle an error', async () => {
      tasksRepository.delete.mockResolvedValue({ affected: 0 });
      expect(tasksService.deleteTask(null, mockUser)).rejects.toThrow(
        NotFoundException,
      );
    });
  });

  describe('updateTask', () => {
    it('should calls TasksRepository.save() and returns the result', async () => {
      const task: TaskDto = {
        title: 'title',
        description: 'description',
        status: Status.OPEN,
      };
      tasksRepository.findOne.mockResolvedValue(task);
      tasksRepository.save.mockResolvedValue(task);
      expect(tasksRepository.findOne).not.toHaveBeenCalled();
      expect(tasksRepository.save).not.toHaveBeenCalled();
      const result = await tasksService.updateTask('1', task, mockUser);
      expect(tasksRepository.findOne).toHaveBeenCalled();
      expect(tasksRepository.save).toHaveBeenCalled();
      result.hasOwnProperty('user') && delete result.user;
      expect(result).toEqual(task);
    });
  });
});
