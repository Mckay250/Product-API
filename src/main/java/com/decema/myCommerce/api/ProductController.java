package com.decema.myCommerce.api;

import com.decema.myCommerce.model.Product;
import com.decema.myCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public void addProduct(@Valid @NotNull @RequestBody Product product) {
        productService.addProduct(product);
    }

    @PostMapping("/addProducts")
    public void addProducts(@Valid @NotNull @RequestBody List<Product> products) {
        productService.addProducts(products);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product/{category}")
    public List<Product> getProductByCategory(@PathVariable String category) {
        return productService.getProductByCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/updateProducts")
    public void updateProduct(@RequestBody Product productToUpdate) {
        productService.updateProduct(productToUpdate);
    }
}