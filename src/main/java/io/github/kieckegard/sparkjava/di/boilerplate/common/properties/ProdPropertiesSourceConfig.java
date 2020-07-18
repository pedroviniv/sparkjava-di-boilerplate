/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.common.properties;

import io.github.kieckegard.sparkjava.di.boilerplate.common.profiles.Profiles;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * In case we're using the profile {@link Profiles#PRODUCTION} the file in which
 * the settings will be fetched will be the application-prod.properties
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Profile(Profiles.PRODUCTION)
@Configuration
@PropertySource("classpath:application-prod.properties")
public class ProdPropertiesSourceConfig {
    
}
