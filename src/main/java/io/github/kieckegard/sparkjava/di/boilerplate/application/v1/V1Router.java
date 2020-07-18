/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.v1;

import io.github.kieckegard.sparkjava.di.boilerplate.application.v1.cors.CorsFilter;
import io.github.kieckegard.sparkjava.di.boilerplate.application.v1.product.ProductRouter;
import io.github.kieckegard.sparkjava.di.boilerplate.application.v1.security.SecurityFilter;
import org.springframework.stereotype.Component;
import static spark.Spark.before;
import static spark.Spark.exception;
import static spark.Spark.path;

/**
 * The v1 router. It is composed by all the application routers that corresponds
 * to our API first version.
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Component
public class V1Router {

    private final ProductRouter productRouter;

    private final CorsFilter corsFilter;
    private final SecurityFilter securityFilter;

    public V1Router(ProductRouter productRouter, CorsFilter corsFilter, SecurityFilter securityFilter) {
        this.productRouter = productRouter;
        this.corsFilter = corsFilter;
        this.securityFilter = securityFilter;
    }

    public void init() {
        path("/api/v1", () -> {
            
            exception(Exception.class, (exception, request, response) -> {
                exception.printStackTrace();
            });

            /**
             * registering filters under v1 router
             */
            before("/*", this.securityFilter);
            before("/*", this.corsFilter);

            /**
             * initializing application routers
             */
            this.productRouter.init();
        });
    }
}
