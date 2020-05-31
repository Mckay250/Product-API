package com.decema.myCommerce.repository;

import com.decema.myCommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository <Category, Integer> {

    Optional<Category> deleteByName(String name);

    Optional<Category> findByName(String category);

}
