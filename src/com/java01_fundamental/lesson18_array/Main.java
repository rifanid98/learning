package com.java01_fundamental.lesson18_array;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /**
         * Array 1 Dimension
         *
         * dataType[] variableName = {value1,value2,.... valueN}
         * variableName[0] -> value1
         * variableName[N-1] -> valueN
         */
        int[] arrayOfNumber = {1,2,3,4};
        System.out.println(arrayOfNumber[0]);   // 1
        System.out.println(arrayOfNumber[1]);   // 2
        System.out.println(arrayOfNumber[2]);   // 3
        System.out.println(arrayOfNumber[3]);   // 4
        System.out.println(Arrays.toString(arrayOfNumber)); // [1, 2, 3, 4]

        String[] arrayOfString = {"Adnin", "Rifandi", "Sutanto", "Putra"};
        System.out.println(arrayOfString[0]);   // Adnin
        System.out.println(arrayOfString[1]);   // Rifandi
        System.out.println(arrayOfString[2]);   // Sutanto
        System.out.println(arrayOfString[3]);   // Putra
        System.out.println(Arrays.toString(arrayOfString)); // [Adnin, Rifandi, Sutanto, Putra]

        /**
         * Print element of Array with loop
         */
        // manual for loop
        int[] getArrayValueWithForLoop = {1,2,3,4};
        for (int i = 0; i <= getArrayValueWithForLoop.length; i++) {
            System.out.println("getArrayValueForLoop - " + i);
        }
        // (in javascript) :
        // for in
        // forEach
        for (int arrayValue: getArrayValueWithForLoop) {
            System.out.println("getArrayValueForLoop for in - " + arrayValue);
        }

        /**
         * Array pass by Reference
         */
        int[] array1 = {1,2,3,4};   // [1,2,3,4]
        int[] array2 = array1;      // [1,2,3,4]
        array2[0] = 100;            // array1 = [100,2,3,4]
        // array2 = [100,2,3,4]
        System.out.println(array1[0]);

        /**
         * Array Method
         */
        /** Array convertion */
        // convert array to string
        int[] myArray = {1,2,3,4};
        System.out.println(Arrays.toString(myArray)); // [1,2,3,4]

        /** Array copy */
        // copy array elements to new variable
        int[] currentArray = {1,2,3,4};
        int[] newArray = Arrays.copyOf(currentArray, currentArray.length); // copy all of elements
        int[] newArray2 = Arrays.copyOf(currentArray, 3); // copy 3 elements start from index 0
        System.out.println(Arrays.toString(newArray2));
        System.out.println(Arrays.toString(currentArray) + " " + currentArray);
        System.out.println(Arrays.toString(newArray) + " " + newArray);

        // copy array elements with range
        int[] copiedArray = Arrays.copyOfRange(currentArray, 1, 3); // copy array from index 1 to index 2 (3-1)
        System.out.println(Arrays.toString(copiedArray)); // [2,3,4]

        /** Array fill */
        // fill empty array with value
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 1);
        System.out.println(Arrays.toString(filledArray));

        /** Array comparasion */
        // check if equal between two arrays
        int[] firstArray = {1,2};
        int[] secondArray = {1,2};
        boolean match = Arrays.equals(firstArray, secondArray); // returning boolean
        System.out.println(match);

        // check which index is not match
        int[] firstArray2 = {1,2};
        int[] secondArray2 = {1,3};
        int mismatch = Arrays.mismatch(firstArray2, secondArray2); // returning int
        System.out.println(mismatch);

        /** Array search */
        int[] targetArray = {1,2,3,4};
        Arrays.sort(targetArray);
        int targetValue = 3;
        int targetIndex = Arrays.binarySearch(targetArray, targetValue);
        System.out.println(targetIndex);


        /**
         * Array 2 Dimensions
         */
        int[][] array2Dimensions = {
                {1, 2},
                {3, 4}
        };
        System.out.println(Arrays.deepToString(array2Dimensions)); // [[1,2], [3,4]]
        for (int i = 0; i < array2Dimensions.length; i++) {
            System.out.println(Arrays.toString(array2Dimensions[i]));
        }
    }
}
