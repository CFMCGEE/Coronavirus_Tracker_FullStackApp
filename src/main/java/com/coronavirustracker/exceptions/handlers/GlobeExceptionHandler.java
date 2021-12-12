package com.coronavirustracker.exceptions.handlers;

import com.coronavirustracker.exceptions.GlobalException;
import com.coronavirustracker.exceptions.details.error.ErrorFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobeExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<?> handleGlobeException() {

        ErrorFound error = new ErrorFound(HttpStatus.NOT_FOUND.value() + " NOT FOUND", "There was an error in the code! \uD835\uDC02\uD835\uDC21\uD835\uDC1E\uD835\uDC1C\uD835\uDC24 \uD835\uDC08\uD835\uDC27\uD835\uDC2D\uD835\uDC1E\uD835\uDC25\uD835\uDC25\uD835\uDC22\uD835\uDC23");

        return new ResponseEntity<>(error, null, HttpStatus.NOT_FOUND);

    }

}
