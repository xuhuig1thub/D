package com.a.artifact.listeners;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-15 23:32
 */
//@Component
@Slf4j
public class MApplicationListener5 implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        log.info("onApplicationEvent(ApplicationStartedEvent)---"+event.getSpringApplication()
                +"-"+event.getArgs()+"-"+event.getApplicationContext());
    }
}
