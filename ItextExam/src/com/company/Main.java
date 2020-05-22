package com.company;
import FileHandlers.CommaFile;
import FileHandlers.FileHandler;
import FileHandlers.PipeFile;
import FileHandlers.SpaceFile;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Vitor Mouzinho
 * date 05/22/20
 *
 * This project is a solution for the coding challange
 * presented by Itext
 *
 * description of challange:
 * ﻿Please study the example input files in the directory ./input_files and
 * the sample output ./model_output.txt. Develop a program that reads the input
 * files and produces the outputs as shown in ./model_output.txt.
 *
 * You can use any of the following languages to do this:
 *
 * - Java
 * - C#
 *
 * You can use the editor or IDE of your choice, but please make sure you bring it
 * to the interview, so you can make some modifications to it. If you don't own a
 * laptop, please let us know we will provide you with a virtual machine that you
 * can use.
* */
public class Main {
    /*Instance of PipeFile object, stores pipe files information*/
    static PipeFile pipeFile;
    /*Instance of CommaFile object, stores and handles information for comma file*/
    static  CommaFile commaFile;
    /*Instance of SpaceFile object, stores and handles information of space file*/
    static SpaceFile spaceFile;
    /*Array consisting of */
    static FileHandler people[];
    /*names of people within entry*/
    enum names{
        Hingis,
        Kelly,
        Kournikova,
        Seles,
        Abercrombie,
        Bishop,
        Bonk,
        Bouillon,
        Smith
    }

    public static void main(String[] args) {
        commaFile = new CommaFile("TextFiles/comma.txt",",");
        pipeFile = new PipeFile("TextFiles/pipe.txt","\\|");
        spaceFile = new SpaceFile("TextFiles/space.txt"," ");
        people = new FileHandler[]{pipeFile, commaFile, spaceFile};
        try {
            //to make sure file is truncated before starting writing data to it
            new FileWriter(new File("OutPutFileCheckHere/output.txt")).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputOne();
        outPutTwo();
        outPutThree();
    }
    /**
     * This method is responsible to produce the output 1
    * */
    public static void outputOne(){
        pipeFile.writeHeaderToFile("Output 1:\n");
        writeToFile(names.Hingis.name());
        writeToFile(names.Kelly.name());
        writeToFile(names.Kournikova.name());
        writeToFile(names.Seles.name());
        writeToFile(names.Abercrombie.name());
        writeToFile(names.Bishop.name());
        writeToFile(names.Bonk.name());
        writeToFile(names.Bouillon.name());
        writeToFile(names.Smith.name());
        System.out.println("LOG:Output1 written successfully");
    }
    /**
     * This method is responsible to produce the output 3
     * */
    public static void outPutThree(){
        pipeFile.writeHeaderToFile("\nOutput 3:\n");
        writeToFile(names.Smith.name());
        writeToFile(names.Seles.name());
        writeToFile(names.Kournikova.name());
        writeToFile(names.Kelly.name());
        writeToFile(names.Hingis.name());
        writeToFile(names.Bouillon.name());
        writeToFile(names.Bonk.name());
        writeToFile(names.Bishop.name());
        writeToFile(names.Abercrombie.name());
        System.out.println("LOG:Output3 written successfully");
    }
    /**
     * This method is responsible to produce the output 2
     * */
    public static void outPutTwo(){
        pipeFile.writeHeaderToFile("\nOutput 2:\n");
        writeToFile(names.Abercrombie.name());
        writeToFile(names.Kelly.name());
        writeToFile(names.Bishop.name());
        writeToFile(names.Seles.name());
        writeToFile(names.Bonk.name());
        writeToFile(names.Bouillon.name());
        writeToFile(names.Kournikova.name());
        writeToFile(names.Hingis.name());
        writeToFile(names.Smith.name());
        System.out.println("LOG:Output2 written successfully");
    }
    /**
     * @param lastname last name of the person you wish to write to the file
     * This method will search for the specified last name and its corresponding information
     * it will then append the entry of the person to the output file
    * */
    public static void writeToFile(String lastname){
        for (FileHandler person:people){
            if(person.checkIfPersonExists(lastname)){
                person.writeToFile(lastname);
                return;
            }
        }
    }
}
