/**
 * Inheritance
 * 
 * Properties and methods of the parent class, 
 * inherited to the child class.
 */

namespace inheritance {

    class Computer {
        name: String;
        vendor: String;

        constructor(name: String, vendor: String) {
            this.name = name;
            this.vendor = vendor;
        }

        public on(): void {
            console.log(`Computer ${this.name} is booting up`);
        }

        public off(): void {
            console.log(`Computer ${this.name} is shutting down`);
        }
    }

    class Laptop extends Computer {

        /**
         * You can access the properties of the parent class, 
         * directly from the class that inherits it.
         */
        public getVendor(): void {
            // vendor is Computer's property
            console.log(`Vendor Name\t: ${this.vendor}`);
        }
    }   

    /** 
     * computer class has a constructor. therefore, 
     * the laptop class also has a constructor inherited 
     * from the computer class .
     */
    const acer = new Laptop('Acer Aspire', 'Acer');
    /** 
     * properties and method of the parent class 
     * is inherited too
     */
    acer.on();
    acer.off();
    acer.getVendor(); // you still can access child class methods and properties
}