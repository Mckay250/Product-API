package com.decema.myCommerce.service;

import com.decema.myCommerce.model.Product;
import com.decema.myCommerce.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    // private final ProductDao productDao;
    @Autowired
    private ProductRepository repository;

    // @Autowired
    // public ProductService(@Qualifier("fakeDao") ProductDao productDao) {
    //     this.productDao = productDao;
    // }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> addProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Product> getProductByCategory(String category) {
        return repository.findAllByCategory(category);
    }

    public String deleteProduct(Integer id) {
        repository.deleteById(id);
        return "Product removed from the database";
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setImgUrl(product.getImgUrl());
        existingProduct.setOnSale(product.getOnSale());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setRating(product.getRating());
        return repository.save(existingProduct);
    }

}
