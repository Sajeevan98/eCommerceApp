package com.ak.productcatalog.controller;

import com.ak.productcatalog.model.Product;
import com.ak.productcatalog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product>  getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductByCategoryId(@PathVariable Long categoryId){
        return productService.getProductByCategoryId(categoryId);
    }
}