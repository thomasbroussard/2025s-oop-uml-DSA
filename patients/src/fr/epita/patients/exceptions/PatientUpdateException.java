package fr.epita.patients.exceptions;

import java.sql.SQLException;

public class PatientUpdateException extends Exception {
    public PatientUpdateException(String message, Exception e) {
        super(message, e);
    }
}
