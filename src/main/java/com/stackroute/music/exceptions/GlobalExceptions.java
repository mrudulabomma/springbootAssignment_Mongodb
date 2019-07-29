package com.stackroute.music.exceptions;

import com.stackroute.music.exceptions.TrackAlreadyExistsException;
import com.stackroute.music.exceptions.TrackNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(final TrackNotFoundException exception){



        return new ResponseEntity<String>("not found", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TrackAlreadyExistsException.class)

    public ResponseEntity<?> handleException(final TrackAlreadyExistsException exception) {


        return new ResponseEntity<String>("already exists", HttpStatus.CONFLICT);
    }


    }