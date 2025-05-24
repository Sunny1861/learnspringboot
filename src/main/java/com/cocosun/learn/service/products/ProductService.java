package com.cocosun.learn.service.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cocosun.learn.model.products.Product;

@Service
public class ProductService {

    private final Map<Long, Product> productRepo = new HashMap<>();
    private long idCounter = 1;

    public List<Product> getAll() {
        return new ArrayList<>(productRepo.values());
    }

    public Product getById(Long id) {
        return productRepo.get(id);
    }

    public Product save(Product product) {
        product.setId(idCounter++);
        productRepo.put(product.getId(), product);
        return product;
    }

    public Product update(Long id, Product product) {
        if (!productRepo.containsKey(id)) {
            return null;
        }
        product.setId(id);
        productRepo.put(id, product);
        return product;
    }

    public boolean delete(Long id) {
        return productRepo.remove(id) != null;
    }
}
