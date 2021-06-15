import {
  ConflictException,
  InternalServerErrorException,
} from '@nestjs/common';
import { EntityRepository, Repository } from 'typeorm';
import { AuthCredentialsDto } from './dto/auth-credential.dto';
import { User } from './users.entity';
import * as bcrypt from 'bcryptjs';

@EntityRepository(User)
export class UsersRepository extends Repository<User> {
  async createUser(authCredentialsDto: AuthCredentialsDto): Promise<User> {
    const user = this.create(authCredentialsDto);

    const salt = await bcrypt.genSalt();
    const hashedPassword = await bcrypt.hash(authCredentialsDto.password, salt);

    user.password = hashedPassword;

    try {
      await this.save(user);
      delete user.password;
      return user;
    } catch (error) {
      if (Number(error.code) === 23505) {
        throw new ConflictException(
          `username ${authCredentialsDto.username} already exists`,
        );
      } else {
        throw new InternalServerErrorException();
      }
    }
  }
}
