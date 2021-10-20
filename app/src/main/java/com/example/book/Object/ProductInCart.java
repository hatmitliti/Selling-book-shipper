package com.example.book.Object;

public class ProductInCart {
    private  String name;
    private  int price;
    private  int qualyti;

    public ProductInCart() {
    }

    public ProductInCart(String name, int price, int qualyti) {
        this.name = name;
        this.price = price;
        this.qualyti = qualyti;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQualyti() {
        return qualyti;
    }

    public void setQualyti(int qualyti) {
        this.qualyti = qualyti;
    }
}
