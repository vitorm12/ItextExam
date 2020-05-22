package FileHandlers;

import com.company.Person;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Scanner;

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
    /*HashMap to store each entry for the corresponding file*/
    protected HashMap<String, Person> personMap;
    /*array to store data when its split*/
    protected String[] dataSplit;
    /**
     * @return personMap holds the entries for each file
     * getter for personMap
    * */
    public HashMap<String, Person> getPersonMap(){
        return personMap;
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
            this.personMap = new HashMap<String, Person>();
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
    protected abstract void parseString(String lineToParse);
    /**
     * @param name name of person
     * @return boolean if the entry exists within this instance
     * checks if an entry exists within the HashMap of this instance
     * */
    public boolean checkIfPersonExists(String name){
        return this.personMap.containsKey(name);
    }
    /**
     * This method is used to read information from the file
     * */
    protected void readFile(){
        while (fileReader.hasNextLine()){
            parseString(fileReader.nextLine());
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
    /**
     * @param name name of entry to write to file
     * This method is used to retrieve an entry from this objects Hashmap
     * and append the information to the file.
     * */
    public void writeToFile(String name){
        String entryToWriteToFIle = this.personMap.get(name).toString()+"\n";
        try {
            Files.write(Paths.get("OutPutFileCheckHere/output.txt"), entryToWriteToFIle.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
