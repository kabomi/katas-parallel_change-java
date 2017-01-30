package com.pduda.field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {


    private ShoppingCart shoppingCart = new ShoppingCart();

    @Test
    public void singleItem_numberOfProductsInTheCart() throws Exception {
        shoppingCart.add(10);

        Assert.assertEquals(1, shoppingCart.numberOfProducts());
    }

    @Test
    public void singleItem_totalPrice() throws Exception {
        shoppingCart.add(10);

        Assert.assertEquals(10, shoppingCart.calculateTotalPrice());
    }

    @Test
    public void singleItem_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() throws Exception {
        shoppingCart.add(100);

        Assert.assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void singleItem_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() throws Exception {
        shoppingCart.add(99);

        Assert.assertFalse(shoppingCart.hasDiscount());
    }

    @Test
    public void multipleItems_numberOfProductsInTheCart() throws Exception {
        shoppingCart.add(10);
        shoppingCart.add(20);

        Assert.assertEquals(2, shoppingCart.numberOfProducts());
    }

    @Test
    public void multipleItem_totalPrice() throws Exception {
        shoppingCart.add(10);
        shoppingCart.add(120);

        Assert.assertEquals(130, shoppingCart.calculateTotalPrice());
    }


    @Test
    public void multipleItems_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() throws Exception {
        shoppingCart.add(200);
        shoppingCart.add(90);

        Assert.assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void multipleItems_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() throws Exception {
        shoppingCart.add(90);
        shoppingCart.add(80);

        Assert.assertFalse(shoppingCart.hasDiscount());
    }
}
