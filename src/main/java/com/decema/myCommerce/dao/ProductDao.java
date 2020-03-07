package com.decema.myCommerce.dao;

import com.decema.myCommerce.model.Product;

import java.util.UUID;

public interface ProductDao {
    int insertProduct(UUID id, Product product);

    default int insertProduct(Product product) {
        UUID id = UUID.randomUUID();
        return insertProduct(id, product);
    }
}
