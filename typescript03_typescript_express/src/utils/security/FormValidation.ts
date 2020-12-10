import Joi from "joi";
import { TObject } from "../constants/types";

type MySchema = {
    [key: string]: any;
}

// type TObject = {
//     [key: string]: any;
// }

/**
 * Custom Joi Error Handling
 */
function joiError(error: TObject): string {
    const joiError = error.error.details[0];
    const errorMessage = joiError.message;

    return errorMessage;
}

class FormValidation {
    private schema: MySchema;
    private fields: TObject;
    private field: string[];

    constructor(
        schema: MySchema,
        fields: TObject,
        field: string[] = []
    ) {
        this.field = field;
        this.fields = fields;
        this.schema = schema;

        if (field) this.dynamic();
        this.static();
    }

    /** 
     * Use this code to validate full of fields you created
     * 
     * const valid = await new FormValidation(loginSchema, body);
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
     * const valid = await new FormValidation(loginSchema, body, fieldToPatch);
     * if (valid) //your code
     */
    dynamic(): Promise<string | Boolean> {
        const dynamicSchema = Object.keys(this.schema)
            .filter(key => this.field.includes(key))
            .reduce((obj: TObject, key: string): Object => {
                obj[key] = this.schema[key];
                return obj;
            }, {});

        return new Promise((resolve, reject) => {
            const validate = Joi.object(dynamicSchema).validate(this.fields);

            if (validate.error) {
                reject(joiError(validate));
            }

            resolve(true);
        });
    }
}

export default FormValidation;