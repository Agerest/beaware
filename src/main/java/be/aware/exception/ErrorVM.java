package be.aware.exception;

import lombok.Data;

@Data
public class ErrorVM {

    private final String message;
    private final String description;
}
