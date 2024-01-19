package holdings.indsys.iLabel.advice;

import com.mongodb.DuplicateKeyException;
import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.security.SignatureException;

@RestControllerAdvice
@Hidden
public class CustomExceptionHandler {


    @ExceptionHandler({BadCredentialsException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    ProblemDetail handleAuthenticationException(Exception e) {
        ProblemDetail problemDetail = null;
        problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(401),
                e.getMessage()
        );
        problemDetail.setProperty("message", "Username or password is incorrect");
        return problemDetail;
    }

    @ExceptionHandler({AuthenticationCredentialsNotFoundException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    ProblemDetail handleAuthenticationCredentialsNotFoundException(Exception e) {
        ProblemDetail problemDetail = null;
        problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(401),
                e.getMessage()
        );
        problemDetail.setProperty("message", "User not found");
        return problemDetail;
    }

    @ExceptionHandler({AccountStatusException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    ProblemDetail handleAccountStatusException(AccountStatusException e) {
        ProblemDetail problemDetail = null;
        problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(401),
                e.getMessage()
        );
        problemDetail.setProperty("message", "User account is not active");
        return problemDetail;
    }

    @ExceptionHandler({SignatureException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    ProblemDetail handleInvalidBearerException(SignatureException e) {
        ProblemDetail problemDetail = null;
        problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(401),
                e.getMessage()
        );
        problemDetail.setProperty("message", "JWT signature not valid. Invalid Bearer token.");
        return problemDetail;
    }

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    ProblemDetail handleAccessDeniedException(AccessDeniedException e) {
        ProblemDetail problemDetail = null;
        problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(401),
                e.getMessage()
        );
        problemDetail.setProperty("message", "Authorization failed");
        return problemDetail;
    }

    @ExceptionHandler({ExpiredJwtException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    ProblemDetail handleExpiredJwtException(ExpiredJwtException e) {
        ProblemDetail problemDetail = null;
        problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(401),
                e.getMessage()
        );
        problemDetail.setProperty("message", "Bearer token expired");
        return problemDetail;
    }

    @ExceptionHandler({InsufficientAuthenticationException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    ProblemDetail handleInsufficientAuthenticationException(InsufficientAuthenticationException e) {
        ProblemDetail problemDetail = null;
        problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(401),
                e.getMessage()
        );
        problemDetail.setProperty("message", "Bearer token expired or invalid");
        return problemDetail;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ProblemDetail handleOtherException(Exception e) {
        ProblemDetail problemDetail = null;
        problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(401),
                e.getMessage()
        );
        problemDetail.setProperty("message", "Something went wrong");
        return problemDetail;
    }

}
