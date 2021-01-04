package com.a.artifact.config;

import com.a.artifact.pojo.User;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-21 0:28
 */
@Configuration
@Slf4j
public class MAutoConfiguration  implements EnvironmentAware {


    @Bean
//    @Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User user(){
        return new User();
    }

    private Environment env;

    public String getStringValue(String key) {

        return env.getProperty(key);

    }

    public Long getLongValue(String key) {

        String value = getStringValue(key);

        try {

            return Long.parseLong(value);

        } catch (Exception e) {

            log.error("字符串转换Long失败：{} = {}", key, value);

        }

        return 0L;

    }

    public int getIntValue(String key) {

        return getLongValue(key).intValue();

    }

    @Override

    public void setEnvironment(Environment environment) {

        this.env = environment;

    }


}
