/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.core.products.repository;

import io.github.kieckegard.sparkjava.di.boilerplate.core.products.Product;
import io.github.kieckegard.sparkjava.di.boilerplate.core.products.ProductData;
import java.util.Set;

/**
 * Contract that defines a place where to persist our product objects.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public interface ProductRepository {
   
    /**
     * creates a new product with the given data
     * @param product
     * @return the created product
     */
    Product create(ProductData product);
    
    /**
     * list all the created products so far
     * @return 
     */
    Set<Product> listAll();

}
