/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.core.products.repository.memory;

import io.github.kieckegard.sparkjava.di.boilerplate.core.products.Product;
import io.github.kieckegard.sparkjava.di.boilerplate.core.products.ProductData;
import io.github.kieckegard.sparkjava.di.boilerplate.core.products.repository.ProductRepository;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import static java.util.stream.Collectors.toSet;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * In memory implementation of {@link ProductRepository}
 * it just uses a hash map to persist the products.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class InMemoryProductRepository implements ProductRepository {
    
    private final Map<String, Product> products = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Product create(ProductData data) {
        
        final String id = UUID.randomUUID().toString();
        
        final Product product = Product.builder()
                .id(id)
                .productData(data)
                .build();
        
        this.products.put(id, product);
        
        return product;
    }

    @Override
    public Set<Product> listAll() {
        
        final Set<Product> allProducts = this.products.values()
                .stream()
                .collect(toSet());
        
        return allProducts;
    }
    
}
