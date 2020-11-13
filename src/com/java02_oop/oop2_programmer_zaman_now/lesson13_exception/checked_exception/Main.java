package com.java02_oop.oop2_programmer_zaman_now.lesson13_exception.checked_exception;

import com.java02_oop.oop2_programmer_zaman_now.lesson11_record_class.LoginRequest;

public class Main {

    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest("", null);

        /* Single Exception */
        try {
            ValidationUtil.validate(loginRequest);
            System.out.println("Data Valid");
        } catch (ValidationException e) {
            System.out.println("Data Invalid");
            System.out.println("Terjadi error :\t" + e.getMessage());
        }

        /* Multiple Exception 1 */
        try {
            ValidationUtil.validate(loginRequest);
            System.out.println("Data Valid");
        } catch (ValidationException e) {
            System.out.println("Data Invalid");
            System.out.println("Terjadi error :\t" + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Data Null!");
            System.out.println("Error\t:" + e.getMessage());
        }

        /* Multiple Exception 3 */
        try {
            ValidationUtil.validate(loginRequest);
            System.out.println("Data Valid");
        } catch (ValidationException | Exception e) {
            System.out.println("Data Invalid");
            System.out.println("Terjadi error :\t" + e.getMessage());
        }

        /* Finally Exception */
        /*
         * Blok Finally akan tetap dieksekusi meskipun
         * terjadi error ataupun tidak
         */
        try {
            ValidationUtil.validate(loginRequest);
            System.out.println("Data Valid");
        } catch (ValidationException | Exception e) {
            System.out.println("Data Invalid");
            System.out.println("Terjadi error :\t" + e.getMessage());
        } finally {
            System.out.println("Validasi selesai");
        }
    }
}
