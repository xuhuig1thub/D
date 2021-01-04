package com.a.artifact.listeners;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-15 23:38
 */
@Component
@Slf4j
public class MApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent e) {
        if(e instanceof ApplicationStartingEvent) {
            ApplicationStartingEvent  event=(ApplicationStartingEvent)e;
            log.info("onApplicationEvent(ApplicationStartingEvent )---" + event.getSpringApplication() + "---" + event.getArgs());
        }
        if(e instanceof ApplicationEnvironmentPreparedEvent){
            ApplicationEnvironmentPreparedEvent event=(ApplicationEnvironmentPreparedEvent)e;
            log.info("onApplicationEvent(ApplicationEnvironmentPreparedEvent)---"
                    +event.getSpringApplication()+"-"+event.getArgs()+"-"+event.getEnvironment());
        }
        if(e instanceof ApplicationContextInitializedEvent){
            ApplicationContextInitializedEvent event=(ApplicationContextInitializedEvent)e;
            log.info("onApplicationEvent(ApplicationContextInitializedEvent)---"+event.getSpringApplication()
                    +"-"+event.getArgs()+"-"+event.getApplicationContext());
        }
        if(e instanceof ApplicationPreparedEvent){
            ApplicationPreparedEvent event=(ApplicationPreparedEvent)e;
            log.info("onApplicationEvent(ApplicationPreparedEvent)---"+event.getSpringApplication()
                    +"-"+event.getArgs()+"-"+event.getApplicationContext());
        }
        if(e instanceof ApplicationStartedEvent){
            ApplicationStartedEvent event=(ApplicationStartedEvent)e;
            log.info("onApplicationEvent(ApplicationStartedEvent)---"+event.getSpringApplication()
                    +"-"+event.getArgs()+"-"+event.getApplicationContext());
        }
        if(e instanceof AvailabilityChangeEvent){
            log.info("onApplicationEvent(AvailabilityChangeEvent)---");
        }
        if(e instanceof ApplicationReadyEvent){
            log.info("onApplicationEvent(ApplicationReadyEvent)---");
        }
        if(e instanceof WebServerInitializedEvent){
            log.info("onApplicationEvent(WebServerInitializedEvent)---");
        }
        if(e instanceof ContextRefreshedEvent){
            log.info("onApplicationEvent(ContextRefreshedEvent)---");
        }

    }
}
