package com.decema.myCommerce.service;

import com.decema.myCommerce.dao.ProductDao;
import com.decema.myCommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(@Qualifier("fakeDao") ProductDao productDao) {
        this.productDao = productDao;
    }

    public int addProduct(Product product) {
        return productDao.insertProduct(product);
    }
}
