package fr.epita.patients.exceptions;

public class PatientCreationException extends Exception {

    public PatientCreationException(String message, Exception e) {
        super(message, e);
    }
}
