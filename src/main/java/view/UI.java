package view;

import java.time.LocalDate;
import java.util.Collections;

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

    public static void parsearguments(String[] args) throws ParseException {
//System.out.println("Witaj w aplikacji");

        Options options = new Options();

        options.addOption("report1", false, "wyswietl raport pierwszy");
        options.addOption("report2", false, "wyswietl raport drugi");
        options.addOption("from", true, "wyswietl raport od podanej daty");
        options.addOption("help", false, "wyswietl pomoc");
        options.addOption("path", true, "sciezka");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        dateFromUser = cmd.getOptionValue("from");
        String path = cmd.getOptionValue("path");

//        try {
//        } catch (Exception e) {
//            dateFromUser = sampleDate;
//        }

        if (cmd.getOptionValue("from") == null) {
            dateFromUser = sampleDate;
        } else {
            dateFromUser = cmd.getOptionValue("from");
        }

        if (path == null) {
            path = "src/main/resources";
        }

        sampleDate = "01/01/1900";
//        Collections.sort(ExcelReader.reportsDateRange);
//        LocalDate dateMin = ExcelReader.reportsDateRange.get(0);
//        LocalDate dateMax = ExcelReader.reportsDateRange.get(ExcelReader.reportsDateRange.size() - 1);

        if (dateFromUser == null) {
            dateFromUser = sampleDate;
        }

        if (cmd.hasOption("report1")) {
            PrintReport.printFirstReport(ExcelReader.company(path), dateFromUser);
        }

        if (cmd.hasOption("report2")) {
            PrintReport.printSecondReport(ExcelReader.company(path), dateFromUser);
        } else if (cmd.hasOption("help")) {
            System.out.println("Opcje do wyboru:");
            System.out.println("Aby wybrać raport pierwszy wpisz w konsole -report1");
            System.out.println("Aby wybrać raport drugi wpisz w konsole -report2");
            System.out
                    .println("Aby wybrać zakres dat, wybierz raport i wpisz w konsole -from YYYY/MM/DD -to YYYY/MM/DD");
        } else {
            System.out.println("MASTERS OF DISASTER PRZEDSTAWIAJĄ" + "\nWitaj w aplikacji!"
                    + "\nAby wyświetlić dostępne opcje wpisz -help");
        }
    }
}

//-t -path -date