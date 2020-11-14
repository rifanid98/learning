package com.java03_standard_classes.lesson01_string_class;

public class Main {

    public static void main(String[] args) {
        String name = "Adnin Rifandi Sutanto Putra";
        String nameLowerCase = name.toLowerCase();
        String nameUpperCase = name.toUpperCase();
        int nameLength = name.length();
        String[] nameArray = name.split(" ");
        String nameBlank = "   ";
        String nameEmpty = "";
        char[] nameChar = name.toCharArray();


        System.out.println(name);
        System.out.println(nameLowerCase);
        System.out.println(nameUpperCase);
        System.out.println(nameLength); // spasi dihitung karakter juga
        System.out.println(name.startsWith("Adnin")); // true
        System.out.println(name.endsWith("Putra")); // true
        for (var i = 0; i < nameArray.length; i++) {
            System.out.println("Index name ke " + i + " adalah " + nameArray[i]);
        }
        System.out.println(nameBlank.isBlank()); // dianggap blank ketika hanya diisi spasi, berapapun spasinya
        System.out.println(nameEmpty.isEmpty()); // dianggap kosong, sama sekali tidak ada karakter sebagai value
        System.out.println(name.charAt(0)); // get character of string at index: n
        for (var chars: nameChar) {
            System.out.printf("Karakter %s dari nameChar \n", chars);
        }
    }
}
