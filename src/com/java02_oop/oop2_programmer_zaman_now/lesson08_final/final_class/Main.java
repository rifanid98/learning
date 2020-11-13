package com.java02_oop.oop2_programmer_zaman_now.lesson08_final.final_class;

class SocialMedia {
    String name;
}

final class Facebook extends SocialMedia {

}

// error, karena Facebook sudah menjadi final Class
// class FakeFacebook extends  Facebook {
//
// }

/**
 * - Final Class yaitu class yang sudah tidak bisa diubah lagi.
 *   tidak bisa diextends di class lainnya lagi.
 * - Final Class tidak bisa diturunkan lagi.
 */
public class Main {
}
