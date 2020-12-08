import { Request, Response } from 'express';

class AuthController {
    login(req: Request, res: Response): Response {
        return res.send("login");
    }

    register(req: Request, res: Response): Response {
        return res.send("register");
    }
}

export default new AuthController();