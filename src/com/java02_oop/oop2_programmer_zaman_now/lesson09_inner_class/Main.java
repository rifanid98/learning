package com.java02_oop.oop2_programmer_zaman_now.lesson09_inner_class;

/**
 * Outer Class
 */
class Company {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Inner Class
     */
    public class Employee {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        /**
         * Aaccess private property of outer class
         * @return
         */
        public String getOuterName() {
            return Company.this.name;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        /**
         * Instance of outer class (Company)
         */
        Company company = new Company();
        company.setName("PT. NashTa Global Utama");

        /**
         * Instance of inner class (Employee)
         */
        Company.Employee employee = company.new Employee();
        employee.setName("Adnin");
        // name of parent class / outer class
        System.out.println(employee.getOuterName());
    }
}
