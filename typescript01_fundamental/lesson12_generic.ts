// problem without generic
function getAny(value: any): any {
    return value;
}

console.log(getAny("string").length);   // 6
console.log(getAny(20).length);         // undefined. karena bukan string, jadi gapunya length. 
                                        // not secure juga akhirnya kalo gini

/** 
 * Generic Function
 */
// function() {}
function getGeneric<T>(value: T): T {
    return value;
}

console.log(getGeneric("string").length) // 6
// console.log(getGeneric(22).length);    // error, karena memang number gaada length

// arrow function
// style 1
const genericArrowFunction = <T extends unknown> (value: T): T => {
    return value;
}
// style 2
const genericArrowFunction2 = <T, > (value: T): T => {
    return value;
}

/**
 * Generic Class
 */
class List<T> {
    private data: T[];

    constructor(data: T[]) {
        this.data = data;
    }

    public addData(value: T): void {
        this.data.push(value);
    }

    public addMultiple(value: T[]): void {
        this.data.push(...value);
        // this.data.push(value); // adding array in existing array
    }

    public getData(): T[] {
        return this.data;
    }
}

const list = new List([1,2,3]);
console.log(list.getData());

const list2 = new List([1,2,"3"]);
list2.addData("4");
console.log(list2.getData());

const list3 = new List([1,2,"3"]);
list3.addMultiple(["4", "5"]);
console.log(list3.getData());