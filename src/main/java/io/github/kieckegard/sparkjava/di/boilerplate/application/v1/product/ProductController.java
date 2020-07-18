/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.v1.product;

import io.github.kieckegard.sparkjava.di.boilerplate.common.json.JsonParser;
import io.github.kieckegard.sparkjava.di.boilerplate.core.products.Product;
import io.github.kieckegard.sparkjava.di.boilerplate.core.products.ProductData;
import io.github.kieckegard.sparkjava.di.boilerplate.core.products.repository.ProductRepository;
import java.util.Set;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Component
public class ProductController {
    
    private ProductRepository productRepository;
    private JsonParser jsonParser;

    public ProductController(ProductRepository productRepository, JsonParser jsonParser) {
        this.productRepository = productRepository;
        this.jsonParser = jsonParser;
    }
    
    public Route createProduct() {
        return (Request request, Response response) -> {
          
            final CreateProductRequestPayload payload = this.jsonParser
                    .unmarshall(request.body(), CreateProductRequestPayload.class);
            
            final ProductData productData = ProductData.builder()
                    .title(payload.getTitle())
                    .stock(payload.getStock())
                    .categories(payload.getCategories())
                    .price(payload.getPrice())
                    .build();
            
            final Product created = this.productRepository.create(productData);
            
            response.status(201);
            return created;
        };
    }
    
    public Route listAll() {
        return (Request request, Response response) -> {
          
            Set<Product> products = this.productRepository.listAll();
            return products;
        };
    }
}
