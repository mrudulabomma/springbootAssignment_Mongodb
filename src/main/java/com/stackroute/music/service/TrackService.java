package com.stackroute.music.service;

import com.stackroute.music.exceptions.TrackAlreadyExistsException;
import com.stackroute.music.domain.Track;
import com.stackroute.music.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllTracks();
   public Track getTrackById(String id) throws TrackNotFoundException;



    public boolean deleteTrack(String id);
  public Track updateTrack(Track track);
   public List<Track> findByName(String name);


}
