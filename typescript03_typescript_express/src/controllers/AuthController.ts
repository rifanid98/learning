import { Request, Response } from 'express';
import { TObject } from '../utils/constants/types';
import MyResponse from '../utils/response/MyResponse';
import FormValidation from '../utils/security/FormValidation';
import { loginSchema, registerSchema } from '../utils/security/joiSchemes';
import { passwordHash } from '../utils/security/password';
const db = require("../utils/sequelize/db/models");

class AuthController {
    register = async (req: Request, res: Response) => {
        try {
            const body: TObject = req.body;
            const { username, password } = body;

            const isValid = new FormValidation(registerSchema, body);
            isValid.static()
                .then(async _ => {
                    const hash = await passwordHash(password);
                    const createdUser = await db.user.create({ username, password: hash });
                    delete createdUser.dataValues.password;
                    return new MyResponse(res, createdUser).success()
                })
                .catch((err) => {
                    return new MyResponse(res, null, err).badrequest()
                });
        } catch (error) {
            console.error(error, '<<< AuthController/register');
            return res.status(500).send({
                status: 500,
                error: 'Internal Server Error'
            })
        }
    }

    login(req: Request, res: Response) {
        try {
            const body: TObject = req.body;
            const { username, password } = body;

            const isValid = new FormValidation(loginSchema, body);
            isValid.static()
                .then(async _ => {
                    const user = await db.user.findOne({
                        where: { username }
                    })

                    console.log(user)
                })
                .catch(err => {
                    return new MyResponse(res, null, err).error();
                })
        } catch (error) {
            console.error(error, '<<< AuthController/login');
            return new MyResponse(res, null).error();
        }
    }
}

export default new AuthController();