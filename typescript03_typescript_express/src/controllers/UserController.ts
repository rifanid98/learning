import { Request, Response } from 'express';
import IController from './ControllerInterface';
import FormValidation from '../utils/security/FormValidation';
import { loginSchema } from '../utils/security/joiSchemes';
import { TObject } from '../utils/constants/types';
const db = require('../utils/sequelize/db/models');
import MyResponse from '../utils/response/MyResponse';
import { type } from 'os';

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

    async show(req: Request, res: Response) {
        try {
            const params: TObject = req.params;
            const userData = req.app.locals.credentials.user;
            console.log(userData, '<<< userData');
            const { id } = params;

            if (isNaN(parseInt(id))) {
                return new MyResponse(res, null, 'invalid user id').badrequest();
            }

            const user = await db.user.findOne({ where: { id }, attributes: { exclude: ['password'] }, raw: true });

            if (user) {
                return new MyResponse(res, user).success();
            } else {
                return new MyResponse(res, null, 'user not found').notfound();
            }

        } catch (error) {
            console.error(error, '<<< AuthController/login');
            return new MyResponse(res, null).error();
        }
    }

    update(req: Request, res: Response): Response {
        return res.send("update");
    }

    delete(req: Request, res: Response): Response {
        return res.send("delete");
    }
}

export default new UserController();