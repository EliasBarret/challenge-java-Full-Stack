package br.com.elias.exception;

public class CustomException extends RuntimeException {

	public CustomException(String exception){
        super(exception);
    }
}