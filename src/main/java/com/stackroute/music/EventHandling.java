package com.stackroute.music;

import com.stackroute.music.domain.Track;
import com.stackroute.music.repository.TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class EventHandling implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {
    //@Value("${spring.datasource.url}")
    String s;
    //@Value("${track.id}")
    int id;
    //@Value("${track.name}")
    String name;
    //@Value("${track.comment}")
    String comment;

    @Autowired
    private TrackRepository trackRepository;

    private static final Logger logger= LoggerFactory.getLogger(EventHandling.class);
    @Override
    public void run(String... args) throws Exception {
        logger.info("{}",s);
        trackRepository.save(new Track(id,name,comment));

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        trackRepository.save(new Track(id,name,comment));
        trackRepository.findAll().forEach((track )-> {
            logger.info("{}",s);
        });
        }

    }

