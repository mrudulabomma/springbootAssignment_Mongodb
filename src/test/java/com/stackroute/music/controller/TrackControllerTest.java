package com.stackroute.music.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.music.MusicApplication;
import com.stackroute.music.domain.Track;
import com.stackroute.music.exceptions.TrackAlreadyExistsException;
import com.stackroute.music.service.TrackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = MusicApplication.class)
public class TrackControllerTest {

    private MockMvc mvc;

    @Mock
    private TrackService trackService;

    @InjectMocks
    private TrackController trackController;
    private List<Track> list=null;

    private Track track;

    // write test cases here

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mvc=MockMvcBuilders.standaloneSetup(trackController).build();
        list=new ArrayList<>();
        track=new Track("1", "Girls Like You", "Maroon 5");
        list.add(track);
        track=new Track("2", "Girls Like You", "Maroon 5");
        list.add(track);
        track=new Track("3", "Girls Like You", "Maroon 5");
        list.add(track);
    }

    @Test
    public void getAllTracks() throws Exception {
        when(trackService.getAllTracks()).thenReturn(list);
         mvc.perform(get("/api/v1/track")
             .contentType(MediaType.APPLICATION_JSON)
             .accept(MediaType.APPLICATION_JSON)
             .content(asJsonString(track)))
             .andExpect(MockMvcResultMatchers.status().isOk())
             .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void saveTrackTest() throws Exception {
        when(trackService.saveTrack(track)).thenReturn(track);
        mvc.perform(post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void updateTrack() throws Exception {
        when(trackService.updateTrack(track)).thenReturn(track);
        mvc.perform(put("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void deleteTrackTest() throws Exception {
        when(trackService.deleteTrack("1")).thenReturn(true);
        mvc.perform(delete("/api/v1/track/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}