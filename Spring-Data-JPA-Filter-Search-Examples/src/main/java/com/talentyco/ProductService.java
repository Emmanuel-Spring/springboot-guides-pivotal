package com.talentyco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return productRepository.findAll(keyword);
        }
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

}
