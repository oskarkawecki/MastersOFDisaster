package app;

import java.io.IOException;

import org.apache.commons.cli.ParseException;

import view.UI;

public class App {

    public static void main(String[] args) throws ParseException, IOException {

        UI.parsearguments(args);

    }

}
