package view;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import services.ExcelReader;
import services.PrintReport;

public class UI {

    public static String dateFromUser;
    public static String sampleDate;

    public static void parsearguments(String[] args) throws ParseException, IOException {

        Options options = new Options();
        
        String currentPath = new java.io.File(".").getCanonicalPath();

        options.addOption("report1", false, "wyswietl raport pierwszy");
        options.addOption("report2", false, "wyswietl raport drugi");
        options.addOption("from", true, "wyswietl raport od podanej daty");
        options.addOption("help", false, "wyswietl pomoc");
        options.addOption("path", true, "sciezka");

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            String path = cmd.getOptionValue("path");
            dateFromUser = cmd.getOptionValue("from");
            sampleDate = "01/01/1900";

            if (cmd.getOptionValue("from") == null) {
                dateFromUser = sampleDate;
            }
//        else {
//            dateFromUser = cmd.getOptionValue("from");
//        }
            
            System.out.println("Aby wyswietlic dostepne opcje wpisz -help");

            if (path == null) {
                path = currentPath;
            }

            if (dateFromUser == null) {
                dateFromUser = sampleDate;
            }

            if (cmd.hasOption("report1")) {
                PrintReport.printFirstReport(ExcelReader.company(path), dateFromUser);
            }

            if (cmd.hasOption("report2")) {
                PrintReport.printSecondReport(ExcelReader.company(path), dateFromUser);
            }
            if (cmd.hasOption("help")) {
                System.out.println("Opcje do wyboru:");
                System.out.println("Aby wybrac raport pierwszy wpisz w konsole -report1");
                System.out.println("Aby wybrac raport drugi wpisz w konsole -report2");
                System.out.println(
                        "Aby wybrac zakres dat, wybierz raport i wpisz w konsole -from DD/MM/YYYY -to DD/MM/YYYY");
            }
            
        } catch (Exception ex) {
            // TODO Auto-generated catch block
            System.out.println("Prosze podaj zakres dat w formacie DD/MM/YYYY, np. -from 01/01/2012");
        }
    }
}
