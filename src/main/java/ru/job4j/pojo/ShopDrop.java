package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        int i = index + 1;
        while (i < products.length && products[i] != null) {
            products[i - 1] = products[i];
            i++;
        }
        products[i - 1] = null;
        return products;
    }
}
