import { Response } from 'express';
import { TObject } from '../constants/types';

/**
 * My Custom response.
 */
class MyResponse {
    private res: Response;
    private message: string | null;
    private data: TObject | null;

    constructor(
        res: Response,
        data?: TObject | null,
        message?: string | null,
    ) {
        this.res = res;
        this.message = message ? message : null;
        this.data = data ? data : null;
    }

    public success() {
        return this.res.status(200).send({
            status: 200,
            data: this.data
        })
    }

    public error() {
        return this.res.status(500).send({
            status: 500,
            error: 'Internal Server Error'
        })
    }

    public badrequest() {
        return this.res.status(400).send({
            status: 400,
            error: this.message
        })
    }

    public notfound() {
        let payload: TObject = {
            status: 404,
            data: this.data
        }

        if (this.message) {
            delete payload.data;
            payload.message = this.message;
        }

        return this.res.status(404).send(payload);
    }

    public conflict() {
        return this.res.status(409).send({
            status: 409,
            error: this.message
        })
    }

    public notauthorized() {
        return this.res.status(401).send({
            status: 401,
            error: this.message
        })
    }
}

export default MyResponse;