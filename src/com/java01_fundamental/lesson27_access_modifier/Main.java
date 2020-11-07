package com.java01_fundamental.lesson27_access_modifier;

public class Main {

    public static void main(String[] args) {
        /**
         * Access Modifier
         */
    }

    /* bisa diakses oleh class dalam satu package yang sama */
    static void methodDefault() {
        //
    }

    /* bisa diakses oleh class manapun */
    public static void methodPublic() {
        //
    }

    /* bisa diakses oleh class yang bersangkutan */
    private static void methodPrivate() {
        //
    }

    /* bisa diakses oleh class package yang sama dan subclassnya */
    protected static void methodProtected() {
        //
    }
}
