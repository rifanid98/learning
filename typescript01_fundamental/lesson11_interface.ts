/**
 * Interface
 */
interface Computer {
    type: string;
    on(): void;
    off(): void;
}

abstract class Laptop implements Computer {
    type: string = "laptop";
    abstract name : string;
    
    on(): void {
        console.log("Laptop power on.")
    }
    off(): void {
        console.log("Laptop power off.")
    }

    abstract feature(): void;
}

class MacBook extends Laptop {
    name: string;
    private touchbar: boolean = false;

    constructor(name: string, touchbar: boolean) {
        super();
        this.name = name;
        this.touchbar = touchbar;
    }

    public feature(): void {
        console.log("Touchbar\t: " + this.touchbar)
    }
}

class Alienware extends Laptop {
    name: string;
    private rgb: boolean = false;

    constructor(name: string, rgb: boolean) {
        super();
        this.name = name;
        this.rgb = rgb;
    }

    public feature(): void {
        console.log("RGB\t: " + this.rgb)
    }
}

const macbook = new MacBook("MBP 16 2020", true);
macbook.on();
macbook.off();
macbook.feature();

const alienware = new Alienware("Alienware 2020", true);
alienware.on();
alienware.off();
alienware.feature();
