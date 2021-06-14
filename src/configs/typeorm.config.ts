import { ConfigService } from '@nestjs/config';
import { TypeOrmModuleOptions } from '@nestjs/typeorm';

export const typeormConfig = async (
  configService: ConfigService,
): Promise<TypeOrmModuleOptions> => ({
  ssl: configService.get('NODE_ENV') === 'production',
  extra: {
    ssl:
      configService.get('NODE_ENV') === 'production'
        ? { rejectUnathorized: false }
        : null,
  },
  type: 'postgres',
  host: configService.get('DB_HOST'),
  port: configService.get('DB_PORT'),
  username: configService.get('DB_USER'),
  password: configService.get('DB_PASS'),
  database: configService.get('DB_NAME'),
  autoLoadEntities: true,
  synchronize: true,
});
