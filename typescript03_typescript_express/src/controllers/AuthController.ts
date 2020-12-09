import { Request, Response } from 'express';
import { passwordHash } from '../utils/security/password';
const db = require("../utils/sequelize/db/models");

class AuthController {
    register = async (req: Request, res: Response): Promise<Response> => {
        try {
            const { username, password } = req.body;
            const hash = await passwordHash(password);
            const createdUser = await db.user.create({ username, password: hash });
            return res.status(200).send({
                status: 200,
                data: createdUser
            });
        } catch (error) {
            console.error(error, '<<< AuthController/register');
            return res.status(500).send({
                status: 500,
                error: 'Internal Server Error'
            })
        }
    }

    login(req: Request, res: Response): Response {
        return res.send("login");
    }
}

export default new AuthController();