/**
 * Generics Type
 */

namespace genericsType {

    type Name<T> = T;
    type Age<T> = T;

    type TPerson<T> = {
        name: Name<String>;
        age: Age<Number>;
    }

    let programmer: TPerson<Number>;
    programmer = {
        name: 'Adnin',
        age: 22
    }
    console.log(programmer)
}