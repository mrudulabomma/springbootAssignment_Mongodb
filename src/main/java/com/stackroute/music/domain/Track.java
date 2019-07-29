package com.stackroute.music.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.PostConstruct;
import javax.persistence.*;

/*
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Configuration
*/
@Document
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Value("${track.id}")
    private String id;
    // @Value("${track.name}")
    private String name;
    //  @Value("${track.comment}")
   // @JsonProperty("streamable")
    private String comment;


    /* @PostConstruct
     public void init(){
         System.out.println(id+name+comment);

     }*/
   // @PostConstruct
public Track(){

}

public Track(String id, String name, String comment) {
    this.id=id;
    this.name=name;
    this.comment=comment;
    }

    public Track(int id, String name, String comment) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}

