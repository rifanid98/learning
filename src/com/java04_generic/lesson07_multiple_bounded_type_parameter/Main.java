package com.java04_generic.lesson07_multiple_bounded_type_parameter;

public class Main {
    public static void main(String[] args) {
//        Data<Manager> managerData = new Data<>(new Manager()); // error, Manager Class tidak implements interface CanSayHello
        Data<VicePresident> vicePresidentData = new Data<>(new VicePresident());
    }

    public static interface CanSayHello {
        void sayHello(String name);
    }

    public static abstract class Employee {}

    public static class Manager extends Employee {}

    public static class VicePresident extends Employee implements CanSayHello {

        @Override
        public void sayHello(String name) {
            System.out.println("Hello " + name);
        }
    }

    public static class Data<T extends Employee & CanSayHello> {
        private T data;

        public Data(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
//            this.getData().sayHello(); // bisa memanggil method karena implement CanSayHello
        }
    }
}
