package app;

import org.apache.commons.cli.ParseException;

import view.UI;

public class App {

    public static void main(String[] args) throws ParseException {
        System.out.println("Hello team");
        
     UI.parsearguments(args);  
      
    }

}
