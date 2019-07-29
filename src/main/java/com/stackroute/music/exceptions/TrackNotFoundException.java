package com.stackroute.music.exceptions;

public class TrackNotFoundException extends  Exception {
    private String msg;
    public TrackNotFoundException(){

    }
    public TrackNotFoundException(String msg){
        super(msg);
        this.msg=msg;
    }
}
