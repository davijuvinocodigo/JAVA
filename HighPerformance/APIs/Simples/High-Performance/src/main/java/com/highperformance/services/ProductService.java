package com.highperformance.services;

import com.highperformance.entities.Product;
import com.highperformance.exception.ResourceNotFoundException;
import com.highperformance.repository.ProductRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@CacheConfig(cacheNames = "products")
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @CacheEvict(allEntries = true)
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Cacheable(key = "#id")
    @Transactional(readOnly = true)
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    @Cacheable
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    @CacheEvict(key = "#id")
    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        return productRepository.save(product);
    }

    @Transactional
    @CacheEvict(key = "#id")
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    @Async
    public CompletableFuture<List<Product>> getAllProductsAsync() {
        return CompletableFuture.completedFuture(productRepository.findAll());
    }
}
