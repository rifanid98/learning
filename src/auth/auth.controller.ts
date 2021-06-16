import { Body, Controller, Post } from '@nestjs/common';
// import { ConfigService } from '@nestjs/config';
import { AuthService } from './auth.service';
import { AuthCredentialsDto } from './dto/auth-credential.dto';
import { CredentialsDto } from './dto/credentials.dto';
import { User } from './users.entity';

@Controller('auth')
export class AuthController {
  constructor(private authService: AuthService) {}

  @Post('/signup')
  signUp(@Body() authCredentialsDto: AuthCredentialsDto): Promise<User> {
    return this.authService.signUp(authCredentialsDto);
  }

  @Post('/signin')
  singIn(
    @Body() AuthCredentialsDto: AuthCredentialsDto,
  ): Promise<CredentialsDto> {
    return this.authService.signIn(AuthCredentialsDto);
  }
}
