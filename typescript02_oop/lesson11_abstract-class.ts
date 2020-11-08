/**
 * Abstract Class
 * 
 * - A class that extends an abstract class must implement 
 *   abstract properties and methods as defined in the abstract class.
 * - Abstract properties and methods must use the keyword "abstract".
 * - Abstract properties cannot have a value.
 * - Abstract methods cannot have statements
 */

namespace abstractClass {

    abstract class Animal {
        public name: String;
        public abstract foot: Number; // must be implemented

        constructor(name: String) {
            this.name = name;
        }
        
        public eat(): void {
            console.log(`${this.name} eating.`);
        }

        public abstract walking(): void; // must be implemented
    }

    class Worm extends Animal {
        public foot: Number; // abstract property implementation

        constructor(name: String, foot: Number) {
            super(name);
            this.foot = foot;
        }

        // abstract method implementation
        public walking(): void {
            console.log(`${this.name} walk using the skin`);
        }
    }

    class Cat extends Animal {
        public foot: Number; // abstract property implementation

        constructor(name: String, foot: Number) {
            super(name);
            this.foot = foot;
        }

        // abstract method implementation
        public walking(): void {
            console.log(`${this.name} walks on its feet`);
        }
    }

    const worm = new Worm('Worm', 0);
    worm.eat();
    worm.walking();

    const cat = new Cat('Cat', 4);
    cat.eat();
    cat.walking();
}