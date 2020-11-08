/**
 * Type Parameters in Generic Constraints.
 */

namespace typeParametersGenericsConstraints {

    const getProperty = <T, U extends keyof T> (obj: T, key: U): void => {
        console.log(obj[key]);
    }

    const object = {
        a: 1,
        b: 2,
        c: 3
    }
    getProperty(object, 'a'); // 1
    getProperty(object, 'b'); // 2
    getProperty(object, 'c'); // 3
}