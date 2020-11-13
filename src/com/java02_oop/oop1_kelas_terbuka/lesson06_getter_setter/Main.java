package com.java02_oop.oop1_kelas_terbuka.lesson06_getter_setter;

class Data {
    public int intPublic;
    private int intPrivate;

    public Data() {
        this.intPublic = 0;
        this.intPrivate = 0;
    }

    // getter
    // returning private property
    public void getIntPrivate() {
        System.out.println("Integer Private\t: " + this.intPrivate);
    }

    public void getIntPublic() {
        System.out.println("Integer Public\t: " + this.intPublic);
    }

    // setter
    // setting private property
    public void setIntPrivate(int intPrivate) {
        this.intPrivate = intPrivate;
        //this.intPrivate = intPrivate*100; -> you can do this too
    }

    public void display() {
        System.out.println("Integer Public\t: " + this.intPublic);
        System.out.println("Integer Private\t: " + this.intPrivate);
    }
}

public class Main {

    public static void main(String[] args) {
        Data data = new Data();

        data.intPublic = 100; // +w
        data.display();
        System.out.println();
        
        data.intPublic = 150;
        data.setIntPrivate(150);
        data.display();
        System.out.println();

        data.intPublic = 200;
        data.setIntPrivate(200);
        data.getIntPrivate();
        data.getIntPublic();
        System.out.println();
    }
}
