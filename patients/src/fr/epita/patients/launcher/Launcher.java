package fr.epita.patients.launcher;

import fr.epita.patients.datamodel.Patient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Launcher {

    public static void main(String[] args) throws IOException, ParseException {
        File file  = new File("./patients/patients.csv");

        List<String> lines = Files.readAllLines(file.toPath());
        lines.remove(0); //remove the headers
        List<Patient> patients = new ArrayList<Patient>();
        for (String line : lines) {
            String[] parts = line.split(";");
            //pat_num_HC;pat_lastname;pat_firstname;pat_address;pat_tel;pat_insurance_id;pat_subscription_date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date subscriptionDate = sdf.parse(parts[6]);
            Date now = new Date();
            long rawSeniority = now.getTime() - subscriptionDate.getTime();
            long conversionForOneYear = 1000l * 60 * 60 * 24 * 365;
            double seniorityInYear = rawSeniority / conversionForOneYear;
            System.out.println(seniorityInYear);
            Patient patient = new Patient(parts[0], parts[1],parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), subscriptionDate);
            patients.add(patient);
        }

        Map<String, Double> seniorityMap = new HashMap<String, Double>();


        //implement compute seniority
        System.out.println(patients.size());

    }
}
