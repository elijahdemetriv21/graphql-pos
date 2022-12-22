package com.anymind.pos.exceptions;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;

@Component
public class GraphqlExceptionHandler {

  @ExceptionHandler({GraphQLException.class, ConstraintViolationException.class})
  public ThrowableGraphQLError handle(Exception e) {
    return new ThrowableGraphQLError(e);
  }

  @ExceptionHandler(RuntimeException.class)
  public ThrowableGraphQLError handle(RuntimeException e) {
    return new ThrowableGraphQLError(e, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
  }

}
