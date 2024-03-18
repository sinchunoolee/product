package com.example.Product.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pId;
    private String pName;
    private int pPrice;

    public String getpName() {
        return pName;
    }

    public Product setpName(String pName) {
        this.pName = pName;
        return this;
    }


    public int getpId() {
        return pId;
    }

    public Product setpId(int pId) {
        this.pId = pId;
        return this;

    }

    public int getpPrice() {
        return pPrice;
    }

    public Product setpPrice(int pPrice) {
        this.pPrice = pPrice;
        return this;
    }


    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                '}';
    }
}

