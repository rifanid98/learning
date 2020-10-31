"use strict";
/**
 * Data Type
 */
(function () {
    /* Declaration Style */
    // style 1
    var variable1 = "variable"; // variable1 = 22;      -> error, expected string but given: number
    // style 2
    var variable2 = "variable"; // variable2 = boolean; -> error.
    /* String */
    var string = "String";
    /* Number */
    var number = 100;
    /* Boolean */
    var boolean = true;
    /* Any */
    var any; // like normal variable in javascript
    any = "string"; // you can assign any data type into variable
    any = 100;
    any = boolean;
    any = {};
    any = [];
    any = null;
    any = undefined;
    any = NaN;
    /* Array */
    var array1 = ["A", "B", "C"];
    var array2 = [1, 2, 3];
    var array3 = ["A", 2, {}, []];
    /* Tuples */
    var tuples;
    tuples = ["A", 2]; // correct
    // tuples = [2, "A"];       -> error, must string first following by number
    // tuples = ["A",2, "A"];   -> error. 2 elements expected, but given 3.
    /**
     * Enum
     *
     * uncomment console.log() to see the result
     */
    console.log("MONTH\n--------------");
    var Month;
    (function (Month) {
        Month[Month["JAN"] = 0] = "JAN";
        Month[Month["FEB"] = 1] = "FEB";
        Month[Month["MAR"] = 2] = "MAR";
    })(Month || (Month = {}));
    console.log(Month);
    console.log("Month[0]\t:", Month[0]);
    console.log("Month.JAN\t:", Month.JAN);
    console.log();
    console.log("DAY\n--------------");
    var Day;
    (function (Day) {
        Day[Day["SEN"] = 0] = "SEN";
        Day[Day["SEL"] = 2] = "SEL";
        Day[Day["RAB"] = 3] = "RAB";
    })(Day || (Day = {}));
    console.log(Day);
    console.log("Day[0]\t:", Day[0]);
    console.log("Day.SEN\t:", Day.SEN);
    console.log();
    console.log("COUNTRY\n--------------");
    var Country;
    (function (Country) {
        Country[Country["IDN"] = 10] = "IDN";
        Country[Country["AUS"] = 11] = "AUS";
        Country[Country["MLY"] = 12] = "MLY";
    })(Country || (Country = {}));
    console.log(Country);
    console.log("Country[10]\t:", Country[10]);
    console.log("Country.IDN\t:", Country.IDN);
    console.log();
    console.log("YEAR\n--------------");
    var Year;
    (function (Year) {
        Year["BOOMER"] = "1970";
        Year["GENX"] = "1998";
        Year["MILLENIAL"] = "2000";
    })(Year || (Year = {}));
    console.log(Year);
    // console.log("Year[0]\t:", Year["1970"])
    console.log("Year.JAN\t:", Year.BOOMER); // onlye this way to accessing this enum
    console.log();
})();
