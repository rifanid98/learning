import Joi, { valid } from "joi";
import { TObject } from "../constants/types";

type MySchema = {
    [key: string]: any;
}

/**
 * Custom Joi Error Handling
 */
function joiError(error: TObject): string {
    const joiError = error.error.details[0];
    const errorMessage = joiError.message;

    return errorMessage;
}

class FormValidation {
    private _message: string = "";

    constructor(
        private schema: MySchema,
        private fields: TObject,
        private field: string[] = []
    ) { }

    /** 
     * Use this code to validate full of fields you created
     * 
     * const valid = await new MyFormValidation(loginSchema, body);
     * if (valid) // your code
     */
    static(): Promise<string | Boolean> {
        return new Promise((resolve, reject) => {
            const validate = Joi.object(this.schema).validate(this.fields);

            if (validate.error) {
                reject(joiError(validate));
            }

            resolve(true);
        });
    }

    /**
     * Use this code to dynamic validation of your custom fields.
     * Use this code to validate some of fields.
     * 
     * const body = req.body;
     * const fieldToPatch = Object.keys(body);
     * 
     * const valid = await new MyFormValidation(loginSchema, body, fieldToPatch);
     * if (valid) //your code
     */
    dynamic(): Promise<string | Boolean> {
        return new Promise((resolve, reject) => {
            const dynamicSchema = Object.keys(this.schema)
                .filter(key => this.field.includes(key))
                .reduce((obj: TObject, key: string): Object => {
                    obj[key] = this.schema[key];
                    return obj;
                }, {});
            console.log(dynamicSchema, '<<< dynamicSchema')

            const validate = Joi.object(dynamicSchema).validate(this.fields);

            if (validate.error) {
                reject(joiError(validate));
            }

            resolve(true);
        });
    }

    /**
     * Get Error Message
     */
    get message(): string {
        return this._message;
    }
}

// const FormValidation = (
//     schema: MySchema,
//     fields: TObject,
//     field: string[] = []
// ): Promise<string | Boolean> => {
//     return new Promise((resolve, reject) => {
//         let validation: MyFormValidation;

//         if (field.length > 0) {
//             validation = new MyFormValidation(schema, fields, field);
//         } else {
//             validation = new MyFormValidation(schema, fields);
//         }

//         const isValid = validation.getField() ? validation.dynamic() : validation.static();
//         if (isValid) {
//             resolve(true);
//         } else {
//             reject(validation.message);
//         }
//     })
// }
export default FormValidation;