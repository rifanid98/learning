package com.java02_oop.oop2_programmer_zaman_now.lesson11_record_class;

/**
 * Java Record Class.
 *
 * - Tidak bisa mewarisi class lain
 * - Bisa implement interface
 * - Wajib membuat constructor utama ketika membuat record class
 * - Attribut / propertinya auto jadi final ketika dibuat
 */
public record LoginRequest(String username, String password) { // constructor utama

    /**
     * Compact Constructor
     * @param username
     * @param password
     */
    public LoginRequest {
        // baris code di sini akan selalu dieksekusi
        // layaknya constructor yang normal
    }

    /**
     * Constructor Overloading di Java Record
     * @param username
     */
    public LoginRequest(String username) {
        // harus tetap memanggil constructor utamanya
        this(username, "");
    }
}
