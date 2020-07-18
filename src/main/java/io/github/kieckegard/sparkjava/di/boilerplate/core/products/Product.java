/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.core.products;

import java.util.Objects;

/**
 * Domain object that represents a product
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class Product {
    
    private final String id;
    private final ProductData productData;

    public static class Builder {

        private String id;
        private ProductData productData;

        private Builder() {
        }

        public Builder id(final String value) {
            this.id = value;
            return this;
        }

        public Builder productData(final ProductData value) {
            this.productData = value;
            return this;
        }

        public Product build() {
            return new io.github.kieckegard.sparkjava.di.boilerplate.core.products.Product(id, productData);
        }
    }

    public static Product.Builder builder() {
        return new Product.Builder();
    }

    private Product(final String id, final ProductData productData) {
        this.id = id;
        this.productData = productData;
    }

    public String getId() {
        return id;
    }

    public ProductData getProductData() {
        return productData;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", productData=" + productData + '}';
    }
}
