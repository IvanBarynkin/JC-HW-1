package org.skypro.skyshop.simpleproduct;

import org.skypro.skyshop.product.Product;

public class SimpleProduct extends Product {

    private int cost;

    public SimpleProduct(String name, int cost) {
        super(name);
        try{
            checkCost(cost);
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }


    @Override
    public String toString() {
        return (name + ": " + cost);
    }

}
