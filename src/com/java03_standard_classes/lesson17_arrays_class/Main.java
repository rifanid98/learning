package com.java03_standard_classes.lesson17_arrays_class;

import java.util.Arrays;

/**
 * Arrays Class
 */
public class Main {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,4,4,32,3,423,424,4};
        System.out.println("Numbers\t\t\t:" + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sorted Numbers\t:" + Arrays.toString(numbers));
        System.out.println("Search Numbers\t:" + Arrays.binarySearch(numbers, 4)); // apabila berurutan, akan diambil index paling akhir
        System.out.println("Search Numbers\t:" + Arrays.binarySearch(numbers, 0)); // apabila tidak ada, akan return nilai minus

        int[] allCopiedNumbers = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copied Numbers\t:" + Arrays.toString(allCopiedNumbers));
        int[] rangeCopiedNumbers = Arrays.copyOfRange(numbers, 0, 5); // copy numbers[] from index 0 to index 5
        System.out.println("Copied Numbers\t:" + Arrays.toString(rangeCopiedNumbers) + " (range)");
    }
}
