/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.common.json;

import java.io.Reader;

/**
 * Contract that defines a json parser
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public interface JsonParser {
    
    /**
     * converts the given json to a instance of type T
     * @param <T> generic type associated to the given class type
     * @param json json in which will be converted to a class instance
     * @param desiredType class that gson will create an instance of from
     * the given json
     * @return 
     */
    <T> T unmarshall(String json, Class<T> desiredType);
    
    /**
     * reads the given reader in JSON format and converts it's content
     * to a instance of type T
     * @param <T>
     * @param reader
     * @param desiredType
     * @return 
     */
    <T> T unmarshall(Reader reader, Class<T> desiredType);
    
    /**
     * converts the given java object into a json string
     * @param object
     * @return 
     */
    String marshall(Object object);
}
