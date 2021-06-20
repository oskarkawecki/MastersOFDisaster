package view;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class UI {

    public static void parsearguments(String[] args) throws ParseException {
//System.out.println("Witaj w aplikacji");

        Options options = new Options();

        options.addOption("t", false, "wyswietl raport pierwszy");
        options.addOption("r", false, "wyswietl raport drugi");
        options.addOption("help", false, "wyswietl pomoc" );

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("t")) {
            System.out.println("Raport1");
            
        } else if (cmd.hasOption("r")) {
        	
            System.out.println("Raport2");
            
        } else if (cmd.hasOption("help")) {
        	System.out.println("Opcje do wyboru:");
        	System.out.println("Aby wybraæ raport pierwszy wpisz w konsole -t");
            System.out.println("Aby wybraæ raport drugi wpisz w konsole -r");
            System.out.println("Aby wybraæ zakres dat wpisz w konsole -from YYYY/MM/DD -to YYYY/MM/DD");
            //System.out.println("Aby wybraæ raport za caly rok wpisz w  konsole YYYY");
        } 
        else {
            System.out.println("Aby wybrac pomoc wpisz -help");
           
        }
    }
}