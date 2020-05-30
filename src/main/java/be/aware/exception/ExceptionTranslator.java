package be.aware.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionTranslator {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorVM> processException(HttpServletRequest request,
                                                    Exception ex) {
        log.error("An unexpected error occurred, user: {}, uri: {}, message: {}",
                request.getRemoteUser(), request.getRequestURI(), ex.getMessage(), ex);
        ResponseEntity.BodyBuilder builder;
        ErrorVM errorVM;
        ResponseStatus responseStatus = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
        if (responseStatus != null) {
            builder = ResponseEntity.status(responseStatus.value());
            errorVM = new ErrorVM("error." + responseStatus.value().value(), responseStatus.reason());
        } else {
            builder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
            errorVM = new ErrorVM("error." + HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        return builder.body(errorVM);
    }

}
