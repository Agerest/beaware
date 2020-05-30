package be.aware.exception;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class ErrorVM {

    private final String message;
    private final String description;
}
