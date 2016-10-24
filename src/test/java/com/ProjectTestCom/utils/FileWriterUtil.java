package com.ProjectTestCom.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by olsa on 5/16/2016.
 */
public class FileWriterUtil {
    public BufferedWriter openWriter() throws IOException {
        FileWriter fw = new FileWriter("output.txt");
        return new BufferedWriter(fw);
    }

    public void writeResult(BufferedWriter bw, String s) throws IOException {
        bw.write(s);
        bw.newLine();
    }

    public void closeWriter(BufferedWriter bf) throws IOException {
        bf.close();
    }
}