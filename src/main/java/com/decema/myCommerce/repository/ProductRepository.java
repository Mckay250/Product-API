package com.decema.myCommerce.repository;

import java.util.List;

import com.decema.myCommerce.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAllByCategory(String category);

}