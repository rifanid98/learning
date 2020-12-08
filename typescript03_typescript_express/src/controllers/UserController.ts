import { Request, Response } from 'express';
import IController from './ControllerInterface';

class UserController implements IController {
    create(req: Request, res: Response): Response {
        const body: Object = req.body;
        return res.send(body);
    }

    showAll(req: Request, res: Response): Response {
        return res.send("show all");
    }

    show(req: Request, res: Response): Response {
        return res.send("show detail");
    }

    update(req: Request, res: Response): Response {
        return res.send("update");
    }

    delete(req: Request, res: Response): Response {
        return res.send("delete");
    }
}

export default new UserController();