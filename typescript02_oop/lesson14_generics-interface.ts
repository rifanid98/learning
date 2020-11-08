/**
 * Generics Interface
 */

namespace genericsInterface {
    
    interface IGeneric<T> {
        name: String;
        age: T;
    }

    function genericsFunction<T>(param1: String, param2: T): Object {
        const obj: IGeneric<T> = {
            name: param1,
            age:  param2
        }

        return obj
    }

    console.log(genericsFunction('Gaada', 22));
}