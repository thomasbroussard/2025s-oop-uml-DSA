package fr.epita.biostat.fr.epita.biostat.services;

import fr.epita.biostat.datamodel.BioStatEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVService {

    public static List<BioStatEntry> readEntriesFromFile(String pathname) throws FileNotFoundException {
        File file = new File(pathname);
        Scanner sc = new Scanner(file);
        List<BioStatEntry> entries = new ArrayList<>();
        sc.nextLine(); // skip the first row, it is headers
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replace("\"", "");
            String[] columns = line.split(",");

            BioStatEntry entry = new BioStatEntry(columns[0],
                    columns[1].trim(),
                    Integer.parseInt(columns[2].trim()),
                    Integer.parseInt(columns[3].trim()),
                    Integer.parseInt(columns[4].trim())
            );
            entries.add(entry);
        }
        sc.close();
        return entries;
    }

    public static void writeEntriesToFile(String pathname, List<BioStatEntry> entries) throws FileNotFoundException {
        File file = new File(pathname);
        PrintWriter pw = new PrintWriter(file);
        String headers = """
                "Name",     "Sex", "Age", "Height (in)", "Weight (lbs)"
                """;
        pw.println(headers);
        for (BioStatEntry entry : entries) {
            String line = entry.getName() + ", "
                    + entry.getSex() + ", "
                    + entry.getAge() + ", "
                    + entry.getHeight() + ", "
                    + entry.getWeight();
            pw.println(line);
        }
        pw.close();



    }
}
