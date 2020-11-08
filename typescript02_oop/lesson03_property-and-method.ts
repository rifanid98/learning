/**
 * Property and Method
 * 
 * Property = variable of class
 * Method   = function of class
 */

namespace propertyAndMethod {

    class Hewan {
        /** Property / Variable */
        name: String = '';
        foot: Number = 0;
        mammalia: Boolean = false;

        /** Method / Function */
        breathing() {
            console.log(`${this.name} bernafas`);
        }
    }

    const kodok = new Hewan();
    kodok.name = 'Kodok';
    kodok.foot = 4;
    kodok.mammalia = false;
    kodok.breathing();
}