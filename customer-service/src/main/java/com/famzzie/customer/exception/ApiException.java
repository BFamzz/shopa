package com.famzzie.customer.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.ZonedDateTime;

public record ApiException(

        Boolean success,

        String message,

        @JsonIgnore
        Throwable cause,

        @JsonIgnore
        ZonedDateTime occurredAt) {
}
