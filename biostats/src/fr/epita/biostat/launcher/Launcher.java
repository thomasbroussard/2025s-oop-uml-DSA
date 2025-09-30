package fr.epita.biostat.launcher;

import fr.epita.biostat.datamodel.BioStatEntry;
import fr.epita.biostat.fr.epita.biostat.services.CSVService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) throws FileNotFoundException {
        String pathname = "biostats/biostat.csv";
        List<BioStatEntry> entries = CSVService.readEntriesFromFile(pathname);
        System.out.println(entries.size());


    }




}
