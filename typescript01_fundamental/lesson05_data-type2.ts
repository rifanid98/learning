/**
 * 
 */
(function(){
    /* function (as data type) */
    type Function = (param1: string, param2: number) => string;
    
    const myFunction: Function = (param1: string, param2: number): string => {
        return `${parseInt(param1) + param2}`;
    };

    const sum = myFunction("1",2);
    console.log(sum)

    /* object (as data type) */
    let person = {
        name: "Adnin",
        age: 22
    }

    person = {
        name: "Rifandi",
        age: 23
    }

    /*
        person = {
            address: "Kp. Sinagar"
        }
        // error: address doesn't exists
     */

    /*
        person = {
            name: "Adnin"
        }
        // error: age is missing
     */

     /* union */
     let age: string | number;
     age = "22";
     age = 22;
    //  age = true; -> error

    /*  */

})();