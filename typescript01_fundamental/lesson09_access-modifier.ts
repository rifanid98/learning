/**
 * Access Modifier
 */

class Adnin {
    public name: string = "Adnin";      // accessed from anywhere
    private age: number = 22;           // accessed from inside of class only
    protected married: boolean = false; // accessed from inside of class and sub class
    static religion: string = "islam";  // accessed without instantiating class

    static getReligion(): string {
        return Adnin.religion;
    }
}

console.log(Adnin.getReligion());   // static method
console.log(Adnin);
Adnin.religion = "islam forever InsyaaAllah";   // static property
console.log(Adnin);