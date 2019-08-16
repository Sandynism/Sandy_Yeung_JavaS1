package com.example.cupcakeservice.model;

public class Cupcake {
    public int id;
    public String flavor;
    public String frostingType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getFrostingType() {
        return frostingType;
    }

    public void setFrostingType(String frostingType) {
        this.frostingType = frostingType;
    }

//    public Cupcake(int id, String flavor, String frostingType){
//        this.id = id;
//        this.flavor = flavor;
//        this.frostingType = frostingType;
//    }
}
