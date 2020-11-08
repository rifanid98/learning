/**
 * Readonly Modifier
 * 
 * you can access this but, cannot write it from outer class.
 */

namespace readonly {

    class Read {
        public readonly name: String = 'Adnin';
        protected readonly age: Number = 0;
        private readonly married: Boolean = false;

        constructor() {
            /** You can read and write from its own constructor */
            // this.name = 'Rifandi';
            // this.age = 22;
            // this.married = true;
        }
    }

    class ReadOnly extends Read {
        
        public display(): void {
            // this.age = 22; -> read only! cannot set the value.
            console.log(`Name\t: ${this.name}`); // can read the value.
            console.log(`Age\t: ${this.age}`); // can read the value.
        }
    }

    const readOnly = new ReadOnly();
    readOnly.display();
    console.log();
    console.log(readOnly.name) // can read the calue
    // readOnly.name = "Rifandi"; -> read only! cannot set the value.
}