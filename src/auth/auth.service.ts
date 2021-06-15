import { Injectable, UnauthorizedException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import * as bcrypt from 'bcryptjs';
import { AuthCredentialsDto } from './dto/auth-credential.dto';
import { User } from './users.entity';
import { UsersRepository } from './users.repository';
import { CredentialsDto } from './dto/credentials.dto';
import { JwtService } from '@nestjs/jwt';
import { FindOneOptions } from 'typeorm';

@Injectable()
export class AuthService {
  private findOneOptions: FindOneOptions;

  constructor(
    @InjectRepository(UsersRepository)
    private usersRepository: UsersRepository,
    private jwtService: JwtService,
  ) {
    this.findOneOptions = { loadEagerRelations: false };
  }

  getUser(authCredentialsDto: AuthCredentialsDto): Promise<User[]> {
    return this.usersRepository.find(authCredentialsDto);
  }

  async signUp(authCredentialsDto: AuthCredentialsDto): Promise<User> {
    return this.usersRepository.createUser(authCredentialsDto);
  }

  async signIn(
    authCredentialsDto: AuthCredentialsDto,
  ): Promise<CredentialsDto> {
    const { username, password } = authCredentialsDto;

    const user = await this.usersRepository.findOne(
      { username },
      this.findOneOptions,
    );

    if (user && (await bcrypt.compare(password, user.password))) {
      delete user.password;

      return { token: this.jwtService.sign({ ...user }) };
    } else {
      throw new UnauthorizedException('Please chek your credentials');
    }
  }
}
