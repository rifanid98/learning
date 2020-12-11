import jwt from 'jsonwebtoken';
import { TObject } from '../constants/types';

export const generateToken = (payload: TObject, expiry?: string): string => {
    if (expiry) {
        return jwt.sign(payload, process.env.JWT_TOKEN || "secret", { expiresIn: expiry });
    }
    return jwt.sign(payload, process.env.JWT_TOKEN || "secret");
}

export const verifyToken = (token: string): Promise<string | boolean> => {
    return new Promise((resolve, reject) => {
        try {
            jwt.verify(token, process.env.JWT_TOKEN || "secret");
            resolve(true);
        } catch (error) {
            reject(error);
        }
    })
}