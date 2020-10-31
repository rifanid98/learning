/**
 * Data Type
 */
(function() {
    /* Declaration Style */
    // style 1
    let variable1 = "variable";         // variable1 = 22;      -> error, expected string but given: number
    // style 2
    let variable2: string = "variable"; // variable2 = boolean; -> error.

    /* String */
    let string: string = "String";

    /* Number */
    let number: number = 100;

    /* Boolean */
    let boolean: boolean = true;

    /* Any */
    let any: any;   // like normal variable in javascript
    any = "string"; // you can assign any data type into variable
    any = 100;
    any = boolean;
    any = {};
    any = [];
    any = null;
    any = undefined;
    any = NaN;

    /* Array */
    let array1: string[] = ["A","B","C"];
    let array2: number[] = [1,2,3];
    let array3: any[]    = ["A", 2, {}, []];

    /* Tuples */
    let tuples: [string, number];
    tuples = ["A", 2];          // correct
    // tuples = [2, "A"];       -> error, must string first following by number
    // tuples = ["A",2, "A"];   -> error. 2 elements expected, but given 3.

    /**
     * Enum
     * 
     * uncomment console.log() to see the result
     */
    console.log("MONTH\n--------------")
    enum Month {
        JAN,
        FEB,
        MAR,
    }
    console.log(Month)     
    console.log("Month[0]\t:", Month[0])
    console.log("Month.JAN\t:", Month.JAN)
    console.log()

    console.log("DAY\n--------------")
    enum Day {
        SEN ,
        SEL = 2,
        RAB,
    }
    console.log(Day)     
    console.log("Day[0]\t:", Day[0])
    console.log("Day.SEN\t:", Day.SEN)     
    console.log()

    console.log("COUNTRY\n--------------")
    enum Country {
        IDN = 10,
        AUS,
        MLY,
    }
    console.log(Country)     
    console.log("Country[10]\t:", Country[10])
    console.log("Country.IDN\t:", Country.IDN)
    console.log()
    
    console.log("YEAR\n--------------")
    enum Year {
        BOOMER      = "1970",
        GENX        = "1998",
        MILLENIAL   = "2000"
    }
    console.log(Year)     
    // console.log("Year[0]\t:", Year["1970"])
    console.log("Year.JAN\t:", Year.BOOMER) // onlye this way to accessing this enum
    console.log()
})();