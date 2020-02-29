package com.peery;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

//Given that I visit the site, when I begin shopping, then I expect my cart to be empty.
        @Test
        void initEmptyCart() {
            //Setup
            Cart cart;

            //Execute
            cart = new Cart();

            //Assert
            assertEquals(Collections.EMPTY_LIST, cart.getItems());
        }
//
//Given I have an empty cart, when I add an Item, then I expect to getTotalPrice() reflect the sum of all the Items in my cart, times the quantities of each item.
//

    @Test
    void ShouldAllowAddingItemsToCart() {
            Cart cart = new Cart();

            Item item1 = new Item("Levi's Jeans", 50.00);
            Item item2 = new Item("Running Shoes", 60.00);

            cart.addItem(item1);
            assertEquals(50.00, cart.getTotalPrice());

            cart.addItem(item2);
            assertEquals(110.00, cart.getTotalPrice());
    }

//Given I have an empty cart, when I add more than one of an item, then I expect itemQuantities() to show the number of items I have added.
//

    @Test
    public void ShouldDisplayItemizedList() {
            Cart cart = new Cart();
            assertEquals(cart.itemizedList(), Collections.EMPTY_LIST);

            Item item1 = new Item("North Face Jacket", 300);
            Item item2 = new Item("Dress Slacks", 100);

            cart.addItem(item1);
            cart.addItem(item2);
            assertEquals(new ArrayList<String>(Arrays.asList("North Face Jacket - $300.0", "Dress Slacks - $100.0")), cart.itemizedList());
    }

//Given I have an empty cart, when I add items, then I expect itemizedList() reflect the items I have added along with their price and quantity.
//

    @Test
    void ShouldAllowYouToSeeHowManyOfEachItemIsInTheCart() {
            Cart cart = new Cart();

        Item item1 = new Item("Levi's Jeans", 50.00);
        Item item2 = new Item("Running Shoes", 60.00);

        cart.addItem(item1, 2);
        assertEquals(100.0, cart.getTotalPrice());
    }

//Given I have an empty cart, when I add more than one of an item, then I expect getTotalPrice() to reflect both the item price and quantity.
//

    @Test
    void ShouldAllowAddingMoreThanOneOfAGivenItemToTheCart() {
        Cart cart = new Cart();

        Item item1 = new Item("Levi's Jeans", 50.00);
        Item item2 = new Item("Running Shoes", 60.00);

        cart.addItem(item1, 2);
        assertEquals(100.0, cart.getTotalPrice());
    }

//Given I have a cart with items that are not on sale, when I add items that are on sale, I expect onSaleItems() to include only the items on sale.

    @Test
    void ShouldDisplayTheNamesAndPricesOfItemsOnSale() {
    Cart cart = new Cart();

    Item item1 = new Item("Jeans", 50, false);
    Item item2 = new Item("T-Shirt", 10, true);
    Item item3 = new Item("Jacket", 100, true);

    cart.addItem(item1);
    assertEquals(new ArrayList<String>(), cart.onSaleItems());

        cart.addItem(item2);
        assertEquals(new ArrayList<String>(Arrays.asList("T-Shirt - $10.0")), cart.onSaleItems());

        cart.addItem(item3);
        assertEquals(new ArrayList<String>(Arrays.asList("T-Shirt - $10.0", "Jacket - $100.0")), cart.onSaleItems());
    }
}

