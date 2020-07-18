/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.common.json.gson;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Configuration class that exposes instances of
 * {@link Gson}
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Configuration
public class GsonConfiguration {
    
    @Bean
    public Gson provideGson() {
        return new Gson();
    }
}
