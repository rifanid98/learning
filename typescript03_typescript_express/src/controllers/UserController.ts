import { Request, Response } from 'express';
import IController from './ControllerInterface';
import FormValidation from '../utils/security/FormValidation';
import { loginSchema } from '../utils/security/joiSchemes';
import { TObject } from '../utils/constants/types';

class UserController implements IController {
    create(req: Request, res: Response): Response {
        try {
            const body: TObject = req.body;
            // const isValid = new FormValidation(loginSchema, body);
            // console.log(isValid, '<<< isValid');
            return res.send(body);
        } catch (error) {
            return res.send("error")
        }
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