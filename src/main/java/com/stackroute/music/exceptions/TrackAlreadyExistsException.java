package com.stackroute.music.exceptions;

public class TrackAlreadyExistsException extends  Exception {
    private String msg;
    public TrackAlreadyExistsException(){

    }
    public TrackAlreadyExistsException(String msg){
        super(msg);
        this.msg=msg;
    }
}
