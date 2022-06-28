package ch.bzz.footballTeam.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Tells the User what input they have made wrong
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 14.06.2022
 */
@Provider
public class MyExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    /**
     * Rsponse what the User made Wrong
     * @param exception value of exception
     * @return Message of Exception
     */
  @Override
  public Response toResponse(final ConstraintViolationException exception) {
      return Response.status(Response.Status.BAD_REQUEST)
                     .entity(prepareMessage(exception))
                     .type("text/plain")
                     .build();
  }

    /**
     * prepares the message for the Exception
     * @param exception value of Exception
     * @return message of Exception
     */
  private String prepareMessage(ConstraintViolationException exception) {
      String msg = "";
      for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
          msg+=cv.getPropertyPath()+" "+cv.getMessage()+"\n";
      }
      return msg;
  }
}