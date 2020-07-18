/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * application settings, here it's defined settings like PORT,
 * could be added contextPath and other stuff.
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Component
public class ApplicationSettings {
    
    @Value("${application.port}")
    private int port;

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "ApplicationSettings{" + "port=" + port + '}';
    }
}
