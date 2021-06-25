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
            
            //System.out.println("Aby wyœwietliæ dostêpne opcje wpisz -help");

            if (path == null) {
                path = currentPath;
                System.out.println("Aplikacja pobiera dane z domyœlnej œcie¿ki: " + path);
            } else {
                System.out.println("Aplikacja pobiera dane z podanej œcie¿ki: " + path);
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
                System.out.println("-report1 -aby wybrac raport pierwszy wpisz w konsole");
                System.out.println("-report2 -aby wybrac raport drugi wpisz w konsole");
                System.out.println("-from DD/MM/YYYY -aby wybraæ datê pocz¹tkow¹ raportu");
                System.out.println("-path sciezka -aby wybraæ swoj¹ œcie¿kê z danymi");		
                      //  "Aby wybrac zakres dat, wybierz raport i wpisz w konsole -from DD/MM/YYYY -to DD/MM/YYYY");
            } 
            //else {
             //   System.out.println("Aby wybrac pomoc wpisz -help");
           // }
            
            
        } catch (Exception ex) {
            // TODO Auto-generated catch block
          System.out.println("Coœ posz³o nie tak. Upewnij siê czy prawid³owo wprowadzi³eœ parametry œcie¿ki lub daty." );
          System.out.println("Aby wyœwietliæ dostêpne opcje wpisz -help" );
        }
    }
}
