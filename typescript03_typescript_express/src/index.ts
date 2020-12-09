import express, { Application, Request, Response } from 'express';
import bodyParser from 'body-parser';
import morgan from 'morgan';
import compression from 'compression';
import helmet from 'helmet';
import cors from 'cors';
import { config as dotenv } from 'dotenv';

// Routers
import UserRoutes from './routes/UserRoutes';
import AuthRoutes from './routes/AuthRoutes';

class App {
    public app: Application;

    constructor() {
        this.app = express();
        this.plugins();
        this.routes();
        dotenv();
    }

    protected plugins() {
        this.app.use(bodyParser.json());
        this.app.use(morgan("dev"));
        this.app.use(compression());
        this.app.use(helmet());
        this.app.use(cors());
    }

    protected routes(): void {
        this.app.route("/api/v1").get((req: Request, res: Response) => {
            return res.send("ini adalah route menggunakan typescript");
        });

        this.app.use("/api/v1/auth", AuthRoutes);
        this.app.use("/api/v1/users", UserRoutes);
    }
}

const port: Number = 3230;
const app = new App().app;
app.listen(port, () => {
    console.log(`Server is running at port ${port}`);
});