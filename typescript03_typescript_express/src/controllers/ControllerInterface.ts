import { Request, Response } from 'express';

interface IController {
    create(req: Request, res: Response): Response | Promise<Response>;
    show(req: Request, res: Response): Response | Promise<Response> | any;
    showAll(req: Request, res: Response): Response | Promise<Response>;
    update(req: Request, res: Response): Response | Promise<Response>;
    delete(req: Request, res: Response): Response | Promise<Response>;
}

export default IController;