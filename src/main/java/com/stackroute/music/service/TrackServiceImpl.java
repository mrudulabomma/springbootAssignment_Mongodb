package com.stackroute.music.service;

import com.stackroute.music.exceptions.TrackAlreadyExistsException;
import com.stackroute.music.domain.Track;
import com.stackroute.music.exceptions.TrackNotFoundException;
import com.stackroute.music.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository= trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistsException("track already exists");
        }
        Track savedTrack=trackRepository.save(track);
        if(savedTrack==null){
            throw new TrackAlreadyExistsException("track already exist");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(String id) throws TrackNotFoundException {

       /* Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        if (!trackRepository.findById(id).isPresent()) {
            throw new TrackNotFoundException("track not found");
        }

        return mongoTemplate.findOne(query, Track.class);*/


       if(!trackRepository.findById(id).isPresent()){
           throw new TrackNotFoundException("does not exist");
       }
       return trackRepository.findById(id).get();
    }

    @Override
    public boolean deleteTrack(String id) {
    trackRepository.deleteById(id);

        return true;
    }

    @Override
    public Track updateTrack(Track track) {
        return trackRepository.save(track);
    }

   /* @Override
    public List<Track> findByName(String name) {
        Query query=new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query,Track.class);
    }*/

    @Override
    public List<Track> findByName(String name) {
        return trackRepository.findByName(name);
    }

}



