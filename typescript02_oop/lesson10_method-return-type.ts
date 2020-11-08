/**
 * Return Type.
 */

namespace methodReturnType {

    class Person {
        public name: String = 'Adnin';
        public age: Number = 22;

        // void return type. not returning anything.
        public sayHello(): void {
            console.log('Hai');
        }

        // string return type.
        public getName(): String {
            return this.name;
        }

        // number return type.
        public getAge(): Number {
            return this.age;
        }

        // promise return type
        public async getPromise(): Promise<String> {
            return 'saasa';
        }
    }
}