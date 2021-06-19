package view;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class UI {


	
    
    
    public static void parsearguments(String[] args) throws ParseException{
    	System.out.println("Witaj w aplikacji");
    	
        Options options = new Options();
    	
    	options.addOption("t", false, "wyswietl raport pierwszy");
    	
    	
    	CommandLineParser parser = new DefaultParser();
    	CommandLine cmd = parser.parse( options, args);
    	
    	if(cmd.hasOption("t")) {
    		System.out.println("udalo sie");
    	}
    	else {
    		System.out.println("nieudalo sie");
    	}
    }
    
}
