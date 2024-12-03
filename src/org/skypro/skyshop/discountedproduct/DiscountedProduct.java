package org.skypro.skyshop.discountedproduct;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {
    int baseCost;
    int discountPercent;

    public DiscountedProduct(String name, int baseCost, int discountPercent) {
        super(name);
        this.baseCost = baseCost;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getCost() {
        return baseCost * (100 - discountPercent) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


    @Override
    public String toString() {
        return (name + ": " + getCost() + " " + "(" + discountPercent + "%" + ")");
    }
}
