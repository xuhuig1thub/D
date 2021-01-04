package com.a.artifact.listeners;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-15 23:18
 */
//@Component
@Slf4j
public class MApplicationListener1 implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        log.info("onApplicationEvent(ApplicationStartingEvent )---"+event.getSpringApplication()+"---"+event.getArgs());
    }


}
