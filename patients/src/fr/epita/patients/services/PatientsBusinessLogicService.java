package fr.epita.patients.services;

import fr.epita.patients.datamodel.Patient;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientsBusinessLogicService {

    public Long computeSeniority(Patient patient) {
        Date now = new Date();
        long rawSeniority = now.getTime() - patient.getSubDate().getTime();
        long conversionForOneYear = 1000l * 60 * 60 * 24 * 365;
        return rawSeniority / conversionForOneYear;
        //return Double.longBitsToDouble(rawSeniority) / conversionForOneYear;
    }


    public Map<String, Long> computeSeniorityMap(List<Patient> patients) {
        Map<String, Long> seniorityMap = new HashMap<String, Long>();
        for (Patient patient : patients) {
            seniorityMap.put(patient.getPatNumHC(), computeSeniority(patient));
        }
        return seniorityMap;
    }

}
