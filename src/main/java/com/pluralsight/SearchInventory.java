package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchInventory {

    static void main(String[] args) {

        ArrayList<Product> products = SearchInventory.getInventory();

    }

    private static ArrayList<Product> getInventory() {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            String line = bufReader.readLine();

            while (line != null){
                String[] character = line.split("\\|");
                int id = Integer.parseInt(character[0]);
                String productName = character[1];
                double price = Double.parseDouble(character[2]);
                Product p = new Product(id, productName, price);
                System.out.printf("id: %d - product: %s - Price: $%.2f%n", p.getId(), p.getProduct(), p.getPrice());

                line = bufReader.readLine();
            }
            bufReader.close();

        } catch (IOException e) {
            System.out.println("File not found");
        }

        return null;
    }

}