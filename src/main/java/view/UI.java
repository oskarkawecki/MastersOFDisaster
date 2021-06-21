package view;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import services.ExcelReader;
import services.PrintReport;

public class UI {

    public static void parsearguments(String[] args) throws ParseException {
//System.out.println("Witaj w aplikacji");

        Options options = new Options();

        options.addOption("t", false, "wyswietl raport pierwszy");

        options.addOption("r", false, "wyswietl raport drugi");
        options.addOption("from", true, "wyswietl raport od podanej daty");
        options.addOption("help", false, "wyswietl pomoc");
        options.addOption("path", true, "sciezka");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        String path = cmd.getOptionValue("path");
        String date = cmd.getOptionValue("from");

        if (path == null) {
            path = "src/main/resources/reporter-dane";
            System.out.println("Raport pobrano z katalogu " + path);
        } else {
            System.out.println("Raport pobrano z podanej sciezki " + path);
        }

        String sampleDate = "01/01/1900";

        if (date == null) {
            date = sampleDate;
            System.out.println("Raport przedstawia zakres od: " + date);
        } else {
            System.out.println("Raport przedstawia zakres od: " + date);
        }

        if (cmd.hasOption("t")) {
            PrintReport.printFirstReport(ExcelReader.company(path), date);

        } else if (cmd.hasOption("r")) {
            PrintReport.printSecondReport(ExcelReader.company(path), date);

        } else if (cmd.hasOption("help")) {
            System.out.println("Opcje do wyboru:");

            System.out.println("Aby wybraæ raport pierwszy wpisz w konsole -t");
            System.out.println("Aby wybraæ raport drugi wpisz w konsole -r");
            System.out.println("Aby wybraæ zakres dat wpisz w konsole -from YYYY/MM/DD -to YYYY/MM/DD");
// System.out.println("Aby wybraæ raport za caly rok wpisz w konsole -year
// YYYY");
        } else {
            System.out.println("Aby wybrac pomoc wpisz -help");

        }
    }
}

//-t -path -date