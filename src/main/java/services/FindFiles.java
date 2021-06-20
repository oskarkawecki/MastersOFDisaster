package services;

import java.io.File;
import java.util.ArrayList;

public class FindFiles {

    public static ArrayList<String> filesPaths = new ArrayList<String>();

    public static ArrayList<String> getFiles(String path) {

        File folder = new File(path);

        if (!folder.isDirectory()) {
            filesPaths.add(path);
        } else {
            for (File file : folder.listFiles()) {
                if (file.isDirectory()) {
                    getFiles(file.getAbsolutePath());
                } else {
                    if (file.getName().endsWith(".xls")) {
                        filesPaths.add(file.getAbsolutePath());
                    }
                }
            }
//            return filesPaths;
        }
        return filesPaths;
    }
}