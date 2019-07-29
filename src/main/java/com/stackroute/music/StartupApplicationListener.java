package com.stackroute.music;

import com.stackroute.music.domain.Track;
import com.stackroute.music.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
  trackRepository.save(new Track("1", "modhu", "good girl"));
    }
}
