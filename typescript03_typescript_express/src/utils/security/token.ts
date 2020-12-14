import jwt from 'jsonwebtoken';
import { TObject } from '../constants/types';

export const generateToken = (payload: TObject, expiry?: string): string => {
    if (expiry) {
        return jwt.sign(payload, process.env.JWT_TOKEN || "secret", { expiresIn: expiry });
    }
    return jwt.sign(payload, process.env.JWT_TOKEN || "secret");
}

export const verifyToken = (token: string): Promise<string | boolean | object> => {
    return new Promise((resolve, reject) => {
        try {
            const verified: string | object = jwt.verify(token, process.env.JWT_TOKEN || "secret");
            resolve(verified);
        } catch (error) {
            reject(error);
        }
    })
}