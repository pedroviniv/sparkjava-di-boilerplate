/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.common.json;

import io.github.kieckegard.sparkjava.di.boilerplate.common.json.JsonParser;
import org.springframework.stereotype.Component;
import spark.ResponseTransformer;

/**
 * Sparkjava response transformer that converts java objects returned
 * in the routes method into JSON string.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Component
public class JsonResponseTransformer implements ResponseTransformer {

    private JsonParser jsonParser;

    public JsonResponseTransformer(JsonParser jsonParser) {
        this.jsonParser = jsonParser;
    }
    
    @Override
    public String render(Object o) throws Exception {
        return this.jsonParser.marshall(o);
    }
    
}
