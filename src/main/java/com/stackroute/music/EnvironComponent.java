package com.stackroute.music;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironComponent implements EnvironmentAware {
    private String msg;
    public String getMessage(){
        return msg;
    }
    public EnvironComponent setMessage(String msg){
        this.msg=msg;
        return this;
    }

    @Override
    public void setEnvironment(Environment environment){

        this.msg=environment.getProperty("spring.datasource.url");
    }
}
