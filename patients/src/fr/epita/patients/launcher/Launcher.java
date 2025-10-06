package fr.epita.patients.launcher;

import fr.epita.patients.datamodel.Patient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Launcher {

    public static void main(String[] args) throws IOException {
        File file  = new File("./patients/patients.csv");

        List<String> lines = Files.readAllLines(file.toPath());
        lines.remove(0); //remove the headers
        List<Patient> patients = new ArrayList<Patient>();
        for (String line : lines) {
            String[] parts = line.split(";");
            //patients.add();
        }
        System.out.println(patients.size());

    }
}
