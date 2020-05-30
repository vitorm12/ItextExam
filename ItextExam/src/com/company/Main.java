package com.company;

import FileHandlers.CommaFile;
import FileHandlers.PipeFile;
import FileHandlers.SpaceFile;

import java.io.*;
import java.util.*;

/**
 * @author Vitor Mouzinho
 * date 05/22/20
 * <p>
 * This project is a solution for the coding challange
 * presented by Itext
 * <p>
 * description of challange:
 * ﻿Please study the example input files in the directory ./input_files and
 * the sample output ./model_output.txt. Develop a program that reads the input
 * files and produces the outputs as shown in ./model_output.txt.
 * <p>
 * You can use any of the following languages to do this:
 * <p>
 * - Java
 * - C#
 * <p>
 * You can use the editor or IDE of your choice, but please make sure you bring it
 * to the interview, so you can make some modifications to it. If you don't own a
 * laptop, please let us know we will provide you with a virtual machine that you
 * can use.
 */
public class Main {

    static SortAndMergeLists sorted;
    static FileWriter myWriter;

    public static void main(String[] args) throws IOException {
        sorted = new SortAndMergeLists(
                new CommaFile("TextFiles/comma.txt", ","),
                new PipeFile("TextFiles/pipe.txt", "\\|"),
                new SpaceFile("TextFiles/space.txt", " "));
        try {
            myWriter = new FileWriter(new File("OutPutFileCheckHere/output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //writes Output one to file
        writeToFile(sorted.sortByName(sorted.femaleList, false), "Output 1:");
        writeToFile(sorted.sortByName(sorted.maleList, false), null);
        //writes Output two to file
        writeToFile(sorted.sortByBirthday(), "\nOutput 2:");
        //writes Output three to file
        writeToFile(sorted.sortByName(sorted.mergedList, true), "\nOutput 3:");
        myWriter.close();
    }

    /**
     * @param listToWriteToFile list of to be sorted and written to file
     * @param header header of output
     *  This method is used to write the contents of a list to the output file
     *  and its header.
    * */
    public static void writeToFile(LinkedList<Person> listToWriteToFile, String header) {
        try {
            if (header != null) {
                myWriter.write(header + "\n");
            }
            for (Person personToWriteToFile : listToWriteToFile) {
                myWriter.write(personToWriteToFile.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
