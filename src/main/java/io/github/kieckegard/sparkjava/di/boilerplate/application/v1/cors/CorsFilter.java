/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.v1.cors;

import org.springframework.stereotype.Component;
import spark.Filter;
import spark.Request;
import spark.Response;

/**
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Component
public class CorsFilter implements Filter {

    @Override
    public void handle(Request request, Response response) throws Exception {
        response.header("Access-Control-Allow-Origin", "*");
    }
    
}
