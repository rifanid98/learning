/**
 * Super Constructor.
 * 
 * If you create class inheritance, then the class that 
 * inherits must use the constructor of its parent class
 */

namespace superConstructor {
    
    class Hewan {
        public name: String;
        public foot: Number;

        constructor(name: String, foot: Number) {
            this.name = name;
            this.foot = foot;
        }
    }

    class Katak extends Hewan{
        public poisonous: Boolean;

        constructor(
            name: String,
            foot: Number,
            poisonous: Boolean
        ) {
            super(name, foot); // use parent constructor
            this.poisonous = poisonous;
        }
    }

    const katak = new Katak('Katak', 4, true);
    console.log(katak);
}