package com.ak.productcatalog.service;

import com.ak.productcatalog.model.Product;
import com.ak.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductByCategoryId(Long categoryId){
        return productRepository.findByCategoryId(categoryId);
    }
}
