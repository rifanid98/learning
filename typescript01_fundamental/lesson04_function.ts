(function() {
    /**
     * function functionName(paramName: paramDataType): return dataType {
     *      // code
     * }
     * 
     * supported data type:
     * - void
     * - string
     * - number
     * - boolean
     * - etc
     */

    /**
     * Void
     */
    (function function1(): void {
        console.log("void");
    })();

    /**
     * - parameter
     * - return type
     */
    (function function2(param: string): string {
        return param;
    })("param");

    /**
     * - parameter (+default value)
     * - return type
     */
    (function function3(param: number = 22): number {
        return param;
    })();

    /**
     * - parameter (+default value)
     * - parameter optional
     * - return type
     */
    // case 1
    function function4(param: boolean = false, param2?: string[]): boolean {
        return param;
    }

    function4(true);            // assigning main parameter
    function4(true, ["array"]); // assigning main parameter & optional parameter

    // case 2
    (function function4B(param1: number, param2?: number): number {
        return param1;
        // return param1 + param2; // error, karena param2 belum tentu pasti diisi
    })(2);
})();