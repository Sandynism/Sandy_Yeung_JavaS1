package com.company;

public class VendingMachine {
    public VendingMachine() {}

    int chips, sodaPop, chocolate, mints, gum, popcorn, price, change;

    public void setChips(int chips) {
        this.chips = chips;
    }

    public void setSodaPop(int sodaPop) {
        this.sodaPop = sodaPop;
    }

    public void setChocolate(int chocolate) {
        this.chocolate = chocolate;
    }

    public void setMints(int mints) {
        this.mints = mints;
    }

    public void setGum(int gum) {
        this.gum = gum;
    }

    public void setPopcorn(int popcorn) {
        this.popcorn = popcorn;
    }


    public int getChips() {
        return chips;
    }

    public int getSodaPop() {
        return sodaPop;
    }

    public int getChocolate() {
        return chocolate;
    }

    public int getMints() {
        return mints;
    }

    public int getGum() {
        return gum;
    }

    public int getPopcorn() {
        return popcorn;
    }

    public int getPrice(int price) {
        return price;
    }

    public void setPrice() {
        this.price = price;
    }

    public int getChange(int change) {
        return change;
    }
}
