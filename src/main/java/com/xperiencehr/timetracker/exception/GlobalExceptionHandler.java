package com.xperiencehr.timetracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest request) {
        log.error("BAD REQUEST - URI: {}, RemoteAddr: {}, Message: {}", 
                request.getRequestURI(), 
                request.getRemoteAddr(), 
                ex.getMessage());
        
        ModelAndView mav = new ModelAndView("error/error");
        mav.addObject("message", "Invalid request parameters");
        mav.addObject("status", HttpStatus.BAD_REQUEST.value());
        
        return mav;
    }
    
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNoResourceFound(NoResourceFoundException ex, HttpServletRequest request) {
        log.debug("RESOURCE NOT FOUND - URI: {}, Resource: {}", 
                request.getRequestURI(), 
                ex.getResourcePath());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleGenericException(Exception ex, HttpServletRequest request) {
        log.error("UNHANDLED EXCEPTION - URI: {}, RemoteAddr: {}, Exception Type: {}", 
                request.getRequestURI(), 
                request.getRemoteAddr(), 
                ex.getClass().getName(), 
                ex);
        
        ModelAndView mav = new ModelAndView("error/error");
        mav.addObject("message", "An unexpected error occurred. Please contact support.");
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        
        return mav;
    }
}

