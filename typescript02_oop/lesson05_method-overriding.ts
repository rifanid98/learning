/**
 * Method Overriding.
 * 
 * You can redefine the methods inherited by the child class 
 * from the parent class. this is called the overriding method
 */

 namespace methodOverriding {

    class Hewan {
        name: String;

        constructor(name: String) {
            this.name = name;
        }

        public breathing(): void {
            console.log(`${this.name} breathing`);
        }
    }

    class Fish extends Hewan {

        constructor(name: String) {
            super(name);
        }
    }

    const fish = new Fish('Fish');
    fish.breathing(); // use parent method

    class Worm extends Hewan {

        constructor(name: String) {
            super(name);
        }

        /** Overriding the parent breathing() method */
        public breathing(): void {
            console.log(`${this.name} breathing by skin`);
        }
    }

    const worm = new Worm('Worm');
    worm.breathing(); // use Worm overrided breathing() method
 }