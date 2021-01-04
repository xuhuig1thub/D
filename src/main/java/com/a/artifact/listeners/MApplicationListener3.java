package com.a.artifact.listeners;

import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-15 23:27
 */
//@Component
@Slf4j
public class MApplicationListener3 implements ApplicationListener<ApplicationContextInitializedEvent> {
    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent event) {
            log.info("onApplicationEvent(ApplicationContextInitializedEvent)---"+event.getSpringApplication()
                    +"-"+event.getArgs()+"-"+event.getApplicationContext());
    }
}
