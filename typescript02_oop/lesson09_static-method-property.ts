/**
 * Static Property / Method
 * 
 * Static property / method can be accessed without 
 * having to instantiate a class. However, a property 
 * that has a static access modifier will affect all 
 * its derived classes.
 */

namespace staticMethodAndProperty {

    class Person {
        static personName: String = '';
        static personAge: Number = 0;
    }

    Person.personName = 'Adnin';
    Person.personAge = 22;
    console.log(Person);

    class Person1 extends Person {
        public display(): void {
            console.log(`Person Name\t: ${Person.personName}`);
        }
    }

    class Person2 extends Person {
        public display(): void {
            console.log(`Person Name\t: ${Person.personName}`);
        }
    }

    const person1 = new Person1()
    const person2 = new Person2()
    person1.display(); // Person Name     : Adnin
    person2.display(); // Person Name     : Adnin
    
    Person.personName = 'Adnin Rifandi';
    console.log(Person);
    console.log();    

    person1.display(); // Person Name     : Adnin Rifandi
    person2.display(); // Person Name     : Adnin Rifandi
}