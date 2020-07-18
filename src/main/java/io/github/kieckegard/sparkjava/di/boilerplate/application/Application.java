/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application;

import io.github.kieckegard.sparkjava.di.boilerplate.application.v1.V1Router;
import org.springframework.stereotype.Component;
import static spark.Spark.port;

/**
 * our web application
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Component
public class Application {
    
    private final ApplicationSettings settings;
    private final V1Router v1Router;

    public Application(ApplicationSettings settings, V1Router v1Router) {
        this.settings = settings;
        this.v1Router = v1Router;
    }
    
    /**
     * starts the application
     */
    public void start() {
        
        port(this.settings.getPort());
        this.v1Router.init();
    }
}
