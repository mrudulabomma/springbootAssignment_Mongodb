package com.stackroute.music;

import com.stackroute.music.domain.Track;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class MusicApplication  {


	public static void main(String[] args) {

		SpringApplication.run(MusicApplication.class, args);
	}


}
