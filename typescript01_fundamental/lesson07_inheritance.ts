/**
 * Inheritance Class
 */

 class Animal {
     private life: boolean;

     // super constructor
     constructor(life: boolean) {
         this.life = life;
     }

     public isLife(): boolean {
         if (this.life) {
             return true;
         } 
         
         return false;
     }
 }

 class Camel extends Animal {
     private name: string;
     private type: string;

     // child constructor
     constructor(life: boolean, type: string) {
         super(life);   // super constructor
         this.name = "Camel";
         this.type = type;
     }

     public display(): void {
         console.log("Animal\n----------");
         console.log("Name\t\t: " + this.name);
         console.log("Type\t\t: " + this.type);
         console.log("Is Live?\t: " + this.isLife())
     }
 }

 const camel = new Camel(true, "mammal");
 camel.display();