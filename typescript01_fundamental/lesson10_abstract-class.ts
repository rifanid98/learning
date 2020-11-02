/**
 * Abstract Class
 */
abstract class Vehicle {
    public abstract wheels: number;

    public abstract ignite(): void;
    
    start(): void {
        console.log("bruummmm...");
    }
}

class Car extends Vehicle {
    public wheels: number = 4;

    public ignite(): void {
        console.log("started!");
    }
}

const car = new Car();
car.ignite();
car.start();

class Motocycle extends Vehicle {
    public wheels: number = 2;

    public ignite(): void {
        console.log("started!");
    }
}

const motocycle = new Motocycle();
motocycle.ignite();
motocycle.start();