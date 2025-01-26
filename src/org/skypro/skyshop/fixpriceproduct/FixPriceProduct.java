package org.skypro.skyshop.fixpriceproduct;

import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {

    private final int FIX_COST;

    public FixPriceProduct(String name, int fixCost) {
        super(name);
        try{
            checkCost(fixCost);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        this.FIX_COST = fixCost;
    }

    @Override
    public int getCost() {
        return FIX_COST;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


    @Override
    public String toString() {
        return (name + ": " + FIX_COST);
    }
}
