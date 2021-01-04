package com.a.artifact.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
//@Configuration
//@ConfigurationProperties(prefix = "environment")
@Data
public class Environment{
    Production production;
    Dev dev;

    public Production getProduction() {
        return production;
    }

    public Dev getDev() {
        return dev;
    }
    @Data
    class Production{
        String url;
        String name;

        public void setUrl(String url) {
            this.url = url;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    @Data
    class Dev{
        String url;
        String name;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "production=" + production +
                ", dev=" + dev +
                '}';
    }
}