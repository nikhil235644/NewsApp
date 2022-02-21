package com.cg.newsapp.exception;


public class BadRequestException extends Exception {
	public BadRequestException(String message){
		super(message);
	}
}