/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.common.json.gson;

import com.google.gson.Gson;
import io.github.kieckegard.sparkjava.di.boilerplate.common.json.JsonParser;
import java.io.Reader;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link JsonParser} backed
 * by {@link Gson}
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Component
public class GsonJsonParser implements JsonParser {
    
    private final Gson gson;

    public GsonJsonParser(Gson gson) {
        this.gson = gson;
    }

    @Override
    public <T> T unmarshall(String json, Class<T> desiredType) {
        return this.gson.fromJson(json, desiredType);
    }

    @Override
    public <T> T unmarshall(Reader reader, Class<T> desiredType) {
        return this.gson.fromJson(reader, desiredType);
    }

    @Override
    public String marshall(Object object) {
        return this.gson.toJson(object);
    }
    
    
}
