package com.a.artifact.listeners;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-15 23:24
 */
//@Component
@Slf4j
public class MApplicationListener2 implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        log.info("onApplicationEvent(ApplicationEnvironmentPreparedEvent)---"
                +event.getSpringApplication()+"-"+event.getArgs()+"-"+event.getEnvironment());
    }
}
