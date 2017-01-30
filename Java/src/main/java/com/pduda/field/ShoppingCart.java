package com.pduda.field;

import java.util.ArrayList;
import java.util.Collection;

public class ShoppingCart {
    private Collection<Integer> priceCollection = new ArrayList<>();

    public void add(int price) {
        this.priceCollection.add(price);
    }

    public int calculateTotalPrice() {
        return this.priceCollection.stream().reduce(0, (a,b) -> a+b);
    }

    public boolean hasDiscount() {
        return this.priceCollection.stream().filter(a -> a >= 100).findAny().isPresent();
    }

    public int numberOfProducts() {
        return this.priceCollection.size();
    }
}
