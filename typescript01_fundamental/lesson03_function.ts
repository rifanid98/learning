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

    /* Void */
    function function1(): void {
        console.log("void");
    }

    /* example 1 */
    function function2(param: string): string {
        return param;
    }

    /* example 2 */
    function function3(param: number): number {
        return param;
    }
})();