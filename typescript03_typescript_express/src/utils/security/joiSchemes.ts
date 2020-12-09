import Joi from "joi";

/**
 * Create your own joi schema here.
 * Don't use Joi.object here! use plain object instead
 * 
 * import this schemas to your controller 
 * or models to start validate the data.
 * 
 * import FormValidation from 'path/to/utils/formValidation.js';
 * import {loginSchema} from 'path/to/this/file/js';
 * 
 * const body = req.body;
 * // or
 * const body = {
 *      username: 'root',
 *      password: 'root'
 * }
 * const fieldToPatch = Object.keys(body);
 * const valid = new FormValidation(loginSchema, body)                  // static validation
 * const valid = new FormValidation(loginSchema, body, fieldToPatch)    // dynamic validation
 * 
 */
export const loginSchema = {
    username: Joi.string().email({ minDomainSegments: 2 }).required(),
    password: Joi.string().trim().min(3).required()
};

export const registerSchema = {
    username: Joi.string().email({ minDomainSegments: 2 }).required(),
    password: Joi.string().trim().min(3).required()
};
