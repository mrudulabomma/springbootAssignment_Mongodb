package com.stackroute.music.service;

import com.stackroute.music.domain.Track;
import com.stackroute.music.exceptions.TrackAlreadyExistsException;
import com.stackroute.music.exceptions.TrackNotFoundException;
import com.stackroute.music.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class  TrackServiceTest {
    @Autowired
    Track track;
    @Mock
    TrackRepository trackRepository;
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list=null;

    @Before
    public void setUp()  {
        MockitoAnnotations.initMocks(this);
        track=new Track(1,"fdds","dgslj");
        list=new ArrayList<Track>();
        track.setId("101");
        track.setName("pallavi");
        track.setComment("good");
        track.setId("102");
        track.setName("pd");
        track.setComment("good");
        track.setId("103");
        track.setName("pdfjkvi");
        track.setComment("good");
        list.add(track);

    }

    @Test
    public void saveTrack() throws TrackAlreadyExistsException{
        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack=trackService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);
        verify(trackRepository,times(1)).save(track);
    }

    @Test
    public void getAllTracks() {
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> list2= trackService.getAllTracks();
        Assert.assertEquals(list,list2);
        verify(trackRepository,times(1)).findAll();
    }

    @Test
    public void updateTrack (){
        when(trackRepository.save((Track) any())).thenReturn(track);
        Track updatedTrack=trackService.updateTrack(track);
        Assert.assertEquals(track,updatedTrack);
        verify(trackRepository,times(1)).save(track);
    }
    @Test
   public void deleteTrackTest() throws TrackNotFoundException
  {
   /* boolean deleteTrack=trackService.deleteTrack(track.getId());
     Assert.assertEquals(true,deleteTrack);
       verify(trackRepository,times(1));*/
   doNothing().when(trackRepository).deleteById(any());
   trackService.deleteTrack("1");
   verify(trackRepository,times(1)).deleteById(any());

  }
  @Test
    public void getTrackByIdTest() throws TrackNotFoundException
  {
      when(trackRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(track));
      Track getTrack=trackService.getTrackById("1");
      Assert.assertEquals(track,getTrack);
      verify(trackRepository,times(2)).findById(any());
  }
}