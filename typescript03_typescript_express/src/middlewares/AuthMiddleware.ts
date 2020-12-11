import { Request, Response, NextFunction } from 'express';
import jwt from 'jsonwebtoken';
import MyResponse from '../utils/response/MyResponse';
import { verifyToken } from '../utils/security/token';

export const checkAuth = async (req: Request, res: Response, next: NextFunction): Promise<any> => {
    try {
        const { authorization } = req.headers;

        if (!authorization) {
            return new MyResponse(res, null, 'autorization invalid').notauthorized();
        }

        const token = authorization.split(" ")?.pop()?.toString();

        if (token) {
            await verifyToken(token);
            next();
        } else {
            return new MyResponse(res, null, 'please send token').badrequest();
        }
    } catch (error) {
        console.log(error.toString(), '<<< checkAuth')
        if (error.toString()?.split(": ")[0] === 'TokenExpiredError') {
            return new MyResponse(res, null, error.toString()?.split(': ')?.pop()).badrequest();
        }
        return new MyResponse(res, null).error();
    }
}