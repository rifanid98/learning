/**
 * Type vs Interface
 * similarities and differences.
 */

namespace typeVsInterface {

    /** similarities */
    
    /** #1 */
    type TPerson = {
        name: String;
    }

    class Police implements TPerson {
        name: String;

        constructor(name: String) {
            this.name = name;
        }
    }

    interface IPerson {
        name: String;
    }

    class Teacher implements IPerson {
        name: String;

        constructor(name: String) {
            this.name = name;
        }
    }

    // conclusion:
    // type and interface can be implemented.

    /** #2 */
    const person1: TPerson = {
        name: 'Person'
    }
    const person2: IPerson = {
        name: 'Person'
    };

    // conclusion:
    // type and interface can be a data types.


    /** differences */

    /** #1 */
    type TVariable = String;
    type TObject = {
        key: 'value'
    }

    interface IObject {
        key: 'value'
    }

    // conclusion:
    // - type can be a variable data types or object.
    // - interface can be an object only.

    /** #2 */
    type Things = {
        name: String;
    }
    // type cannot be merged.
    // type Things = {
    //     function: String;
    // }

    // interface can be merged.
    interface Buildings {
        name: String;
    }
    interface Buildings {
        address: String;
    }

    // conclusion:
    // - type cannot be merged.
    // - interface can be merged.

    // solution how to merge type:
    type ThingsName = {
        name: String;
    }
    type ThingsFunction = {
        function: String;
    }
    type MergedThings = ThingsName & ThingsFunction;
    type MergedThingsPartial = ThingsName | ThingsFunction;

    /** #3 */
    class Class {
        name: String = 'Class';
    }
    interface IClass extends Class {
        
    }

    // conclusion:
    // interface can extends class
}