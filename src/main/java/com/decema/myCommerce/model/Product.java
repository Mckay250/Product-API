package com.decema.myCommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Product {
    private final UUID id;
    private final String name;
    private final String category;
    private final int price;
    private final int rating;
    private final String imgUrl;
    private final String description;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public Product(@JsonProperty("id") UUID id,
                   @JsonProperty("name")String name,
                   @JsonProperty("category")String category,
                   @JsonProperty("price")int price,
                   @JsonProperty("rating")int rating,
                   @JsonProperty("imgUrl")String imgUrl,
                   @JsonProperty("description")String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.imgUrl = imgUrl;
        this.description = description;
    }
}