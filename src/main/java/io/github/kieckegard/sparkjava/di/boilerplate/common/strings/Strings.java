/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.common.strings;

/**
 * set of string util methods
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class Strings {
    
    /**
     * verifies if the given string is null or empty
     * obs: strings with " " is considered empty too.
     * @param string
     * @return 
     */
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }
}
