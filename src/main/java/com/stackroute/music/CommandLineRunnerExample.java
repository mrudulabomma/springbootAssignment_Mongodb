package com.stackroute.music;

import com.stackroute.music.domain.Track;
import com.stackroute.music.repository.TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerExample implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnerExample.class);

    @Autowired
    private TrackRepository trackRepository;

    private Track track;

    @Override
    public void run(String... args) throws Exception {

       trackRepository.save(new Track("3", "bommA", "DF"));
       trackRepository.save(new Track("4", "bfd", "gvrf"));
      trackRepository.save(new Track("5", "bowdmA", "sdf"));
       trackRepository.save(new Track("6", "baqA", "ewrtret"));
       //track.init();

       trackRepository.findAll().forEach((track) -> {
          logger.info("{}", track);
       });
    }
}
