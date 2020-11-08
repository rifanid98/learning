/**
 * Generics Class
 */

namespace genericsClass {

    interface IPerson<T> {
        name: T,
        address: T,
        getAddress(): T
    }

    class Person<T> implements IPerson<T> {
        name: T;
        address: T;
        age: T;
        
        constructor(name: T, address: T, age: T) {
            this.name = name;
            this.address = address;
            this.age = age;
        }
        
        getAddress(): T {
            return this.address;
        }
    }

    const person = new Person<String | Number>('Adnin', 'Kp. Sinagar', 22);
    console.log(person.getAddress());
}