/**
 * Getter and Setter.
 * 
 * Getter   -> get the value.
 * Setter   -> set the value;
 */

namespace getterAndSetter {

    class Adnin {
        private _name: String = 'Adnin';
        private _age: Number = 0;

        constructor() {
            console.log(`Hai...${this.name}`)
        }

        /** _name getter setter */
        get name(): String {
            return this._name;
        }

        set name(value: String) {
            this._name = value;
        }

        /** _age getter setter */
        get age(): Number {
            return this._age;
        }

        set age(value: Number) {
            this._age = value;
        }

        public display(): void {
            console.log(`Name\t: ${this._name}`);
            console.log(`Age\t: ${this._age}`);
        }
    }

    /** You can access property like usual */
    const adnin = new Adnin();
    adnin.name = 'Adnin Rifandi';
    adnin.age = 22;
    adnin.display();
}