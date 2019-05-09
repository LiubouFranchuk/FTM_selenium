package com.epam.ftm.Helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class CustomFileReader {

    //NOTE: this all doesn't work so far

    /*

    public readFromFile(String path){

        File file = new File(path);

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileInput.toString();



        /String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;


    }
    */

}

