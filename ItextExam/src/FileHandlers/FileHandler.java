package FileHandlers;

import com.company.Person;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * @author Vitor Mouzinho
 * date: 05/22/20
 * This is an abstact class used for subclassing
 * These are the main methods and objects that each class(PipeFile, CommaFile and SpaceFile)
 * need in order to handle their corrseponding file.
 * */
public abstract class FileHandler {
    /*used to read file*/
    protected Scanner fileReader;
    /*Specified File*/
    private File file;
    /*Delimiter needed to parse file*/
    protected String delimiter;
    /*LinkedList to store Male data*/
    protected LinkedList<Person> maleList;
    /*LinkedList to store female data*/
    protected LinkedList<Person> femaleList;
    /*array to store data when its split*/
    protected String[] dataSplit;
    /**
     * @return femaleList
     * returns female data
    * */
    public LinkedList<Person> getFemaleEntries(){
        return this.femaleList;
    }
    /**
     * @return  maleList
     * returns male data
    * */
    public LinkedList<Person> getMaleEntries(){
        return this.maleList;
    }
    /**
     * @param fileName name of file
     * @param delimiter delimiter to parse the entry
     * constructor for FileHandler takes in the name of the
     * and the delimiter needed to parse the file
     * sets the fields.
     * */
    FileHandler(String fileName, String delimiter){
        try {
            this.file = new File(fileName);
            this.fileReader = new Scanner(file);
            this.delimiter = delimiter;
            this.femaleList = new LinkedList<Person>();
            this.maleList = new LinkedList<Person>();
        }catch (FileNotFoundException e){
            System.out.println("File not found try putting file into correct path");
            e.printStackTrace();
        }
        this.readFile();
    }
    /**
     * @param lineToParse the line from file to be parsed
     * This is an abstract method that is override by children classes
     * each file requires a different way to parse entries from file
     * */
    protected abstract Person parseString(String lineToParse);

    /**
     * This method is used to read information from the file
     * */
    protected void readFile(){
        while (fileReader.hasNextLine()){
            Person nodeToAdd = parseString(fileReader.nextLine());
            if (nodeToAdd.getGender().equals("Male")){
                this.maleList.add(nodeToAdd);
            }else {
                this.femaleList.add(nodeToAdd);
            }
        }
        System.out.println("LOG:File done reading");
        fileReader.close();
    }
    /**
     * @param header header of file
     * This method is used to header information to the output file
     **/
    public void writeHeaderToFile(String header){
        try {
            Files.write(Paths.get("OutPutFileCheckHere/output.txt"), header.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
