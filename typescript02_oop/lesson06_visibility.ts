/**
 * Visibility / Access Modifier
 * 
 * Public       -> Can be accessed from anywhere.
 * Protected    -> Can be accessed from the class and its children.
 * Private      -> Can be accessed from its own class only.
 */

namespace visibility {

    class Class1 {
        public name: String = 'visibility';
        protected inherit: Boolean = true;
        private privacy: Number = 0;
    }

    class Class2 extends Class1 {

        public display(): void {
            // this.privacy -> privacy cannot be accessed here
            this.name = 'class'; // name can be accessed from here
            console.log(`This is value from inherit\t: ${this.inherit}`); // inherit can be accessed here
        }
    }

    const myClass = new Class2();
    myClass.name = 'class'; // name can be accessed from here
    // myClass.inherit -> inherit cannot be accessed here
}