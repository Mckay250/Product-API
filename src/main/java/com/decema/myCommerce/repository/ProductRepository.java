package com.decema.myCommerce.repository;

import java.util.List;
import java.util.Optional;

import com.decema.myCommerce.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByCategoryName(String name);

	public List<Product> findByOnSale(boolean onSale);

	public List<Product> findByName(String name);

	public List<Product> findByNameContaining(String name);
}