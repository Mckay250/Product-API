package com.decema.myCommerce.dao;

import com.decema.myCommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeProductDataAccessService implements ProductDao {

    private static List<Product> DB = new ArrayList<>();

    @Override
    public int insertProduct(UUID id, Product product) {
        DB.add(new Product(id, product.getName(), product.getCategory(), product.getPrice(), product.getRating(),
                product.getImgUrl(), product.getDescription()));
        return 1;
    }
}
