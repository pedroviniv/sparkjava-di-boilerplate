/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.v1.product;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Data structure that represents the create product request
 * payload. The JSON string will converted to a instance of this class.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class CreateProductRequestPayload {
    
    private final String title;
    private final int stock;
    private final Set<String> categories;
    private final BigDecimal price;
    
    private CreateProductRequestPayload(final String title, final int stock, final Set<String> categories, final BigDecimal price) {
        this.title = title;
        this.stock = stock;
        this.categories = categories;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getStock() {
        return stock;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "CreateProductRequestPayload{" + "title=" + title + ", stock=" + stock + ", categories=" + categories + ", price=" + price + '}';
    }
}
