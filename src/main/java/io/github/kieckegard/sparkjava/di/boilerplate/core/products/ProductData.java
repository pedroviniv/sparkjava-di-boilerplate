/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.core.products;

import java.math.BigDecimal;
import java.util.Set;

/**
 * value object that represents data about a product
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class ProductData {
    
    private final String title;
    private final int stock;
    private final Set<String> categories;
    private final BigDecimal price;

    public static class Builder {

        private String title;
        private int stock;
        private Set<String> categories;
        private BigDecimal price;

        private Builder() {
        }

        public Builder title(final String value) {
            this.title = value;
            return this;
        }

        public Builder stock(final int value) {
            this.stock = value;
            return this;
        }

        public Builder categories(final Set<String> value) {
            this.categories = value;
            return this;
        }

        public Builder price(final BigDecimal value) {
            this.price = value;
            return this;
        }

        public ProductData build() {
            return new io.github.kieckegard.sparkjava.di.boilerplate.core.products.ProductData(title, stock, categories, price);
        }
    }

    public static ProductData.Builder builder() {
        return new ProductData.Builder();
    }

    private ProductData(final String title, final int stock, final Set<String> categories, final BigDecimal price) {
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
        return "ProductData{" + "title=" + title + ", stock=" + stock + ", categories=" + categories + ", price=" + price + '}';
    }
}
