/**
 * Generics
 */

namespace generics {

    function generic1<T>(param: T): T {
        return param;
    }

    console.log(generic1("string"));    // style 1
    console.log(generic1<Number>(2));   // style 2
}