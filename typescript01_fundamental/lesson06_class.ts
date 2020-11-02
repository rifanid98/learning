/**
 * 
 */
// style 1
class Person {
    private name: string;
    public age: number = 0;

    constructor(name: string) {
        this.name = name;
    }
}

const person = new Person("Adnin");
person.age = 22;
console.log(person)
// person.name = "Rifandi"; // error, age is private

// style 2
class Human {
    constructor(
        public name: string,
        public age: number
    ) {

    }

    public display(): void {
        console.log("Name\t: ", this.name)
        console.log("Age\t: ", this.age)
    }
}

const human = new Human("Adnin", 22);
human.display();