package fr.epita.biostat.launcher;

import fr.epita.biostat.datamodel.BioStatEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("biostats/biostat.csv");
        Scanner sc = new Scanner(file);
        List<BioStatEntry> entries = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replace("\"", "");
            String[] columns = line.split(",");
            System.out.print(columns[0] + " ");
            System.out.println(columns[1]);

            BioStatEntry entry = new BioStatEntry(columns[0], columns[1] ...);

        }


        //I want a List<BioStatEntry>
        sc.close();
    }
}
