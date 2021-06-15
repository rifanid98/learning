import { ConfigService } from '@nestjs/config';
import { TypeOrmModuleOptions } from '@nestjs/typeorm';

export const typeormConfig = async (
  configService: ConfigService,
): Promise<TypeOrmModuleOptions> => {
  const isProduction = configService.get('NODE_ENV') === 'production';

  const typeOrmModuleOptions: TypeOrmModuleOptions = {
    ssl: isProduction,
    extra: {
      ssl: isProduction ? { rejectUnauthorized: false } : null,
    },
    type: 'postgres',
    host: configService.get('DB_HOST'),
    port: configService.get('DB_PORT'),
    username: configService.get('DB_USER'),
    password: configService.get('DB_PASS'),
    database: configService.get('DB_NAME'),
    autoLoadEntities: true,
    synchronize: true,
    entities: [__dirname + '/../**/*.entity.{js,ts}']
  };

  return typeOrmModuleOptions;
};
