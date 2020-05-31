package com.decema.myCommerce.api;

import com.decema.myCommerce.model.Category;
import com.decema.myCommerce.model.Product;
import com.decema.myCommerce.service.CategoryService;
import com.decema.myCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/api/{category}/products")
    public List<Product> getProductByCategory(@PathVariable String category) {
        return productService.getProductByCategory(category);
    }

    @GetMapping("/api/products/search/name")
    public List<Product> getProductByName(@RequestParam("contains") String name) {
        return productService.findProductByName(name);
    }

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/api/category/productById/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping("/api/{onSale}/products/sale")
    public List<Product> getProductByOnSale(@PathVariable boolean onSale) {
        return productService.getProductByOnSale(onSale);
    }

    @GetMapping("/api/allProducts")
//    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

//    @PostMapping("/addProduct")
    @PostMapping("/api/{category}/addProduct")
    public String addProduct(@NotNull @Valid @RequestBody Product product, @PathVariable String category) {
        Category thisCategory = categoryService.getCategoryByName(category);
        if (thisCategory != null) {
        product.setCategory(thisCategory);}
        else {
            product.setCategory(new Category(category));
        }
        return productService.addProduct(product);
    }

    @DeleteMapping("/api/deleteProduct/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/api/updateProduct")
    public void updateProduct(@RequestBody Product productToUpdate) {
//        productToUpdate.setCategory(new Category(category));
        productService.updateProduct(productToUpdate);
    }
}