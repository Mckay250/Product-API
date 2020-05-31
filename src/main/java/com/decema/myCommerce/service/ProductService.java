package com.decema.myCommerce.service;

import com.decema.myCommerce.model.Product;
import com.decema.myCommerce.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public String addProduct(Product product) {
        repository.save(product);
        return "Product Added";
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Product> getProductByName(String name) {
        return new ArrayList<>(repository.findByName(name));
    }

    public List<Product> findProductByName(String name) {
        return new ArrayList<>(repository.findByNameContaining(name));
    }

    public List<Product> getProductByCategory(String name) {
        //        products = repository.findAllByCategoryName(name);
        return new ArrayList<>(repository.findByCategoryName(name));
    }

    public List<Product> getProductByOnSale(boolean onSale) {
        return repository.findByOnSale(onSale);
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
