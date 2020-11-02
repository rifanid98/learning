/**
 * type
 * 
 * jadi bisa seperti alias dari suatu tipe data
 */
(function() {
    /* type as data type */
    type Name = string;
    type Age = number;

    const myName: Name = "Adnin";
    const myAge: Age = 22;
    console.log("Name\t: ", myName);
    console.log("Age\t: ", myAge);

    /* type as (like an interface) */
    type Person = {
        Name: string,
        Age: number,
        Address: string
    }

    const person: Person = {
        Name: "Adnin",
        Age: 22,
        Address: 'Kp. Sinagar'
    }
    console.log("Object Person\t: ", person);
})();