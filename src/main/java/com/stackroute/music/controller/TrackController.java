package com.stackroute.music.controller;

import com.stackroute.music.exceptions.TrackAlreadyExistsException;
import com.stackroute.music.domain.Track;
import com.stackroute.music.exceptions.TrackNotFoundException;
import com.stackroute.music.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {

    @Autowired
    private TrackService trackService;


    private Track t;
    public TrackController(TrackService userService) {
        this.trackService = trackService;
    }



    @PostMapping("track")
    public Track saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {

        return trackService.saveTrack(track);
    }
    @PostMapping("tracks")
    public ResponseEntity<?> saveTrack1(@RequestBody List<Track> track) throws  TrackAlreadyExistsException {
        ResponseEntity responseEntity;
        for(Track t:track){
            trackService.saveTrack(t);
        }
        responseEntity=new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

    @GetMapping("track/{id}")
    public Track getTrackById(@PathVariable(value = "id") String id) throws TrackNotFoundException {

        return trackService.getTrackById(id);
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") String id) {
        trackService.deleteTrack(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("track")
    public ResponseEntity<Track> updateUser(@RequestBody Track track) {
        trackService.updateTrack(track);
        return new ResponseEntity<Track>(track, HttpStatus.OK);
    }

    @GetMapping("track/name/{name}")
    public ResponseEntity<List<Track>> getTrackByName(@PathVariable(value = "name") String name) {
        List<Track> track = trackService.findByName(name);
        return new ResponseEntity<List<Track>>(track, HttpStatus.OK);
    }

    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<?> notFoundException(final TrackNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}