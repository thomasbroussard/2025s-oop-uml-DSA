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
        sc.nextLine(); // skip the first row, it is headers
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replace("\"", "");
            String[] columns = line.split(",");

            BioStatEntry entry = new BioStatEntry(columns[0],
                    columns[1],
                    Integer.parseInt(columns[2].trim()),
                    Integer.parseInt(columns[3].trim()),
                    Integer.parseInt(columns[4].trim())
            );
            entries.add(entry);
        }

        System.out.println(entries.size());
        //I want a List<BioStatEntry>
        sc.close();
    }
}
