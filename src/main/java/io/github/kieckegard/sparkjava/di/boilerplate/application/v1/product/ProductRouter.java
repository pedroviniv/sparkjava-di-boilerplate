/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.v1.product;

import org.springframework.stereotype.Component;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;

/**
 * defines the product router. Here will be mapped all the product endpoints to
 * product paths.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Component
public class ProductRouter {
    
    private final ProductController productController;

    public ProductRouter(ProductController productController) {
        this.productController = productController;
    }
    
    public void init() {
        
        path("/products", () -> {
           
            post("", productController.createProduct());
            get("", productController.listAll());
        });
    }
}
