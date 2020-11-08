/**
 * Generics Constraints.
 * 
 * Use some built in function in generic
 */

namespace genericsConstraints {
    
    interface Length {
        length: number
    }

    const generic = <T extends Length> (param: T): Number => {
        return param.length;
    }

    const temp: Number = generic('Adnin');
    console.log(temp)
}