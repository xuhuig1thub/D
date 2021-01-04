package com.a.artifact.listeners;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-15 23:30
 */
//@Component
@Slf4j
public class MApplicationListener4 implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        log.info("onApplicationEvent(ApplicationPreparedEvent)---"+event.getSpringApplication()
                +"-"+event.getArgs()+"-"+event.getApplicationContext());
    }
}
