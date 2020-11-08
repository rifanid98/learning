/**
 * Constructor
 * 
 * The constructor will be called or executed first.
 */

namespace constructor {

    /** How constructor work */
    class Hewan {

        constructor() {
            console.log('Constructor called!');
        }
    }

    const kodok = new Hewan(); // Constructor called

    /** Use parameter in constructor */
    class Person {
        name: String;

        constructor(name: String) {
            this.name = name;
            console.log(`Hello ${this.name}`);
        }
    }
    
    const adnin = new Person('Adnin'); // Hello Adnin

    /** Other style to use constructor */
    class Laptop {

        constructor(
            public name: String,
            public vendor: String
        ){
            console.log(`Laptop\t: ${this.name}`);
            console.log(`Vendor\t: ${this.vendor}`);
        }
        
    }

    const acer = new Laptop('Acer Aspire', 'Acer');
}