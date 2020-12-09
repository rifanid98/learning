import Joi from "joi";

/**
 * Custom Joi Error Handling
 */
function joiError(error: any): String {
    const joiError = error.error.details[0];
    const errorMessage = joiError.message;

    return errorMessage;
}

class FormValidation {
    private schema: any;
    private fields: Object;
    private field: String[];

    constructor(schema: any, fields: Object, field: String[] = []) {
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
    static(): Promise<String | Boolean> {
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
    dynamic(): Promise<String | Boolean> {
        const dynamicSchema = Object.keys(this.schema)
            .filter(key => this.field.includes(key))
            .reduce((obj, key) => {
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