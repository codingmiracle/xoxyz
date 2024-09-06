package at.codingmiracle.ticktacktoe.controller.error;

import at.codingmiracle.ticktacktoe.exception.GameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@ControllerAdvice
public class GameControllerAdvice {
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<?> handleHttpClientErrorException(HttpClientErrorException ex) {
		String errorMessages= ex.getMessage();

		log.error("errorMessage : {} ", errorMessages);
		return new ResponseEntity<>(errorMessages,ex.getStatusCode() );
	}

	@ExceptionHandler(GameException.class)
	public ResponseEntity<?> handleRuntimeException(GameException ex) {
		String errorMessages= ex.getMessage();

		log.error("errorMessage : {} ", errorMessages);
		return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST );
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
		String errorMessages= ex.getMessage();

		log.error("errorMessage : {} ", errorMessages);
		return new ResponseEntity<>(errorMessages,HttpStatus.INTERNAL_SERVER_ERROR );
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception ex) {
		String errorMessages= ex.getMessage();

		log.error("errorMessage : {} ", errorMessages);
		return new ResponseEntity<>(errorMessages,HttpStatus.INTERNAL_SERVER_ERROR );
	}
}
