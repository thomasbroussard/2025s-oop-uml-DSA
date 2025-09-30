package fr.epita.biostat.launcher;

import fr.epita.biostat.datamodel.BioStatEntry;
import fr.epita.biostat.fr.epita.biostat.services.CSVService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Launcher {

    public static void main(String[] args) throws FileNotFoundException {
        String pathname = "biostats/biostat.csv";
        List<BioStatEntry> entries = CSVService.readEntriesFromFile(pathname);

        CSVService.writeEntriesToFile("biostats/biostat.out.csv", entries);

        Map<Integer, Integer> countByAge = new LinkedHashMap<Integer, Integer>();
       // Collections.sort(entries, (e1,e2)  -> e1.getAge() - e2.getAge());
        entries.sort(Comparator.comparing(BioStatEntry::getAge));
        for (BioStatEntry entry : entries) {
            Integer age = entry.getAge();
            Integer i = countByAge.computeIfAbsent(age, k -> 1);
            //or
            // Integer i = countByAge.getOrDefault();
            countByAge.put(age, i+1);
        }

        System.out.println(countByAge);
        //23: ....
        //26: ....
        //28: ....
        //29: ....
        //30: ......
        //...
        //design a print function that provides the previous display according to the map containing the distribution


    }




}
