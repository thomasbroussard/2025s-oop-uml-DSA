package fr.epita.patients.services;

import fr.epita.patients.datamodel.Patient;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class PatientsBusinessLogicService {

    public Double computeSeniority(Patient patient) {
        Date now = new Date();
        long rawSeniority = now.getTime() - patient.getSubDate().getTime();
        long conversionForOneYear = 1000l * 60 * 60 * 24 * 365;
        //return 1d * rawSeniority / conversionForOneYear;
        return Double.longBitsToDouble(rawSeniority) / conversionForOneYear;
    }


    public Map<String, Double> computeSeniorityMap(List<Patient> patients) {
        return null;
    }

}
