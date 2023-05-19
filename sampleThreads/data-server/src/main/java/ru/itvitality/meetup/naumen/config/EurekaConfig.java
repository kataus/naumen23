package ru.itvitality.meetup.naumen.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClientsProperties;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class EurekaConfig {
//    @Bean
//    @ConditionalOnMissingBean
//    public LoadBalancerClientFactory loadBalancerClientFactory( LoadBalancerClientsProperties props ) {
//        return new LoadBalancerClientFactory( props ) {
//            @Override
//            protected AnnotationConfigApplicationContext createContext( String name ) {
//                ClassLoader originalClassLoader = Thread.currentThread().getContextClassLoader();
//                Thread.currentThread().setContextClassLoader( this.getClass().getClassLoader() );
//                AnnotationConfigApplicationContext context = super.createContext( name );
//                Thread.currentThread().setContextClassLoader( originalClassLoader );
//                return context;
//            }
//        };
//    }
//}
