package com.java03_standard_classes.lesson14_objects_class;

public class MyObjects {
    public static class Data {
        private String data;

        public Data(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Data)) return false;

            Data data1 = (Data) o;

            return getData() != null ? getData().equals(data1.getData()) : data1.getData() == null;
        }

        @Override
        public int hashCode() {
            return getData() != null ? getData().hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }
}
