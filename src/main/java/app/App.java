package app;

<<<<<<< HEAD
import org.apache.commons.cli.ParseException;

import view.UI;

public class App {

    public static void main(String[] args) throws ParseException {
        System.out.println("Hello team");
        
     UI.parsearguments(args);  
      
=======
import org.apache.poi.ss.usermodel.Workbook;

import services.ExcelReader;
import services.PrintFirstReport;

public class App {

    public static void main(String[] args) {
        
        Workbook example1 = ExcelReader.openExcelFile();
        
        PrintFirstReport.printSheetNames(example1);
        
>>>>>>> refs/remotes/origin/master
    }

}
