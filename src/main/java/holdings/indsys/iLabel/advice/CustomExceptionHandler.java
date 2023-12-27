package holdings.indsys.iLabel.advice;

import holdings.indsys.iLabel.Security.auth.AuthenticationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.SignatureException;

@RestControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ProblemDetail handleSecurityException(Exception e) {
        ProblemDetail problemDetail = null;
        if (e instanceof BadCredentialsException) {
            problemDetail = ProblemDetail.forStatusAndDetail(
                    HttpStatusCode.valueOf(401),
                    e.getMessage()
            );
            problemDetail.setProperty("message", "Authentication failed");
        }

        if (e instanceof AccessDeniedException) {
            problemDetail = ProblemDetail.forStatusAndDetail(
                    HttpStatusCode.valueOf(403),
                    e.getMessage()
            );
            problemDetail.setProperty("message", "Authorization failed");
        }

        if (e instanceof SignatureException) {
            problemDetail = ProblemDetail.forStatusAndDetail(
                    HttpStatusCode.valueOf(403),
                    e.getMessage()
            );
            problemDetail.setProperty("message", "JWT signature not valid");
        }

        if (e instanceof AuthenticationCredentialsNotFoundException) {
            problemDetail = ProblemDetail.forStatusAndDetail(
                    HttpStatusCode.valueOf(404),
                    e.getMessage()
            );
            problemDetail.setProperty("message", "User not found");
        }


        return problemDetail;
    }
}
