import { Provider, UnauthorizedException } from '@nestjs/common';
import { ConfigModule, ConfigService } from '@nestjs/config';
import { JwtModule } from '@nestjs/jwt';
import { Test } from '@nestjs/testing';
import { jwtConfig } from 'src/configs/jwt.config';
import { AuthCredentialsDto } from './dto/auth-credential.dto';
import { JwtStrategy } from './jwt.strategy';
import { User } from './users.entity';
import { UsersRepository } from './users.repository';

const mockUser: User = {
  id: 'id',
  username: 'username',
  password: 'password',
  tasks: [],
};

const mockAuthCredentialsDto: AuthCredentialsDto = {
  username: 'username',
  password: 'password',
};

describe('JwtStrategy', () => {
  let jwtStrategy: JwtStrategy;
  let usersRepository;

  beforeEach(async () => {
    const MockUsersRepository: Provider = {
      provide: UsersRepository,
      useFactory: () => ({
        findOne: jest.fn(),
      }),
    };

    const module = await Test.createTestingModule({
      imports: [
        ConfigModule,
        ConfigService,
        JwtModule.registerAsync({
          imports: [ConfigModule],
          inject: [ConfigService],
          useFactory: jwtConfig,
        }),
      ],
      providers: [JwtStrategy, MockUsersRepository],
    }).compile();

    jwtStrategy = module.get(JwtStrategy);
    usersRepository = module.get(UsersRepository);
  });

  describe('validate', () => {
    it('should validates and returns the user based on JWT payload', async () => {
      usersRepository.findOne.mockResolvedValue(mockUser);
      const result = await jwtStrategy.validate(mockAuthCredentialsDto);
      expect(usersRepository.findOne).toHaveBeenCalled();
      expect(result).toEqual(mockUser);
    });

    it('should throws an unauthorized exception as user cannot be found', async () => {
      usersRepository.findOne.mockResolvedValue(null);
      expect(jwtStrategy.validate(mockAuthCredentialsDto)).rejects.toThrow(
        UnauthorizedException,
      );
    });
  });
});
