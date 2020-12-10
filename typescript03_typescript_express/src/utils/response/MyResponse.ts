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
}

export default MyResponse;