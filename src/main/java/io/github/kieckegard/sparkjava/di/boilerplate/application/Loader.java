/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application;

import io.github.kieckegard.sparkjava.di.boilerplate.common.profiles.Profiles;
import io.github.kieckegard.sparkjava.di.boilerplate.common.strings.Strings;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Executable class that starts that instantiates and launches our application.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class Loader {
    
    private static final String BASE_PACKAGE = "io.github.kieckegard.sparkjava.di.boilerplate";
    
    private static final String PROFILE_ENV = "profile";
    private static final String SPRING_PROFILE_ENV = "spring.profiles.active";
    
    /**
     * get the profile in which the application was executed,
     * if there isn't a env variable pointing to the profile
     * {@link Profiles#DEVELOPMENT} is used.
     * 
     * @return 
     */
    private static String getProfile() {
        String activeProfile = System.getProperty(PROFILE_ENV);
        if (Strings.isNullOrEmpty(activeProfile)) {
            activeProfile = Profiles.DEVELOPMENT;
        }
        return activeProfile;
    }
    
    public static void main(String[] args) {
        
        System.setProperty(SPRING_PROFILE_ENV, getProfile());
        
        final AnnotationConfigApplicationContext ctx 
                = new AnnotationConfigApplicationContext(BASE_PACKAGE);
        
        final Application application = ctx.getBean(Application.class);
        application.start();
    }
}
