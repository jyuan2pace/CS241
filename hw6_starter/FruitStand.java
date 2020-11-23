import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FruitStand {
    private class Fruit {
        private int id;
        private String name;
        private double unitPrice;
        public Fruit(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.unitPrice = price;
        }
    }
    MyHashTableKV<Integer, Fruit> t;
    public FruitStand(String path) {
        //TODO: your code here
        throw new UnsupportedOperationException();
    }

    public double lookup_price(int key) {
        //TODO: your code here
        throw new UnsupportedOperationException();
    }

}
