package JUnitTests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import FileHandlers.CommaFile;
import FileHandlers.PipeFile;
import FileHandlers.SpaceFile;
import com.company.Person;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
/**
 * @author Vitor Mouzinho
 * date 05/22/2020
 * This class is used for JUnit testing
 * All these methods are to ensure that the code
 * is working correctly
* */
public class TestFileHandlers {
    /**
     * checks the data retrieved from the space
     * file to make sure it is in correct format
     * */
    @Test
    public void checkSpaceFileEntries() {
        HashMap<String,Person> peopleInOriginalFile = new HashMap<>();
        peopleInOriginalFile.put("Kournikova",new Person("Kournikova","Anna","Female","6/3/1975","Red"));
        peopleInOriginalFile.put("Hingis",new Person("Hingis","Martina","Female","4/2/1979","Green"));
        peopleInOriginalFile.put("Seles",new Person("Seles","Monica","Female","12/2/1973","Black"));
        SpaceFile space = new SpaceFile("TextFiles/space.txt"," ");
        for(Person person:space.getFemaleEntries()){
            assert peopleInOriginalFile.containsKey(person.getLastName());
            assertEquals(peopleInOriginalFile.get(person.getLastName()).toString(),person.toString());
        }
        assert space.getMaleEntries().isEmpty();
    }
    /**
     * checks the data retrieved from the pipe
     * file to make sure it is in correct format
     * */
    @Test
    public void checkPipeFileEntries(){
        HashMap<String,Person> peopleInOriginalFile = new HashMap<>();
        peopleInOriginalFile.put("Smith",new Person("Smith","Steve","Male","3/3/1985","Red"));
        peopleInOriginalFile.put("Bonk",new Person("Bonk","Radek","Male","6/3/1975","Green"));
        peopleInOriginalFile.put("Bouillon",new Person("Bouillon","Francis","Male","6/3/1975","Blue"));
        PipeFile pipe = new PipeFile("TextFiles/pipe.txt","\\|");
        for(Person person:pipe.getMaleEntries()){
            assert peopleInOriginalFile.containsKey(person.getLastName());
            assertEquals(peopleInOriginalFile.get(person.getLastName()).toString(),person.toString());
        }
        assert pipe.getFemaleEntries().isEmpty();
    }
    /**
     * checks the data retrieved from the comma
     * file to make sure it is in correct format
    * */
    @Test
    public void checkCommaFileEntries(){
        HashMap<String,Person> peopleInOriginalFile = new HashMap<>();
        peopleInOriginalFile.put("Abercrombie",new Person("Abercrombie","Neil","Male","2/13/1943","Tan"));
        peopleInOriginalFile.put("Bishop",new Person("Bishop","Timothy","Male","4/23/1967","Yellow"));
        peopleInOriginalFile.put("Kelly",new Person("Kelly","Sue","Female","7/12/1959","Pink"));
        CommaFile comma = new CommaFile("TextFiles/comma.txt",",");
       for(Person person:comma.getFemaleEntries()){
           assert peopleInOriginalFile.containsKey(person.getLastName());
          assertEquals(peopleInOriginalFile.get(person.getLastName()).toString(),person.toString());
       }
        for(Person person:comma.getMaleEntries()){
            assert peopleInOriginalFile.containsKey(person.getLastName());
            assertEquals(peopleInOriginalFile.get(person.getLastName()).toString(),person.toString());
        }
    }
    /**
     * compares both orginal file and generated file to make sure each are equal
    * */
    @Test
    public void compareBothFiles(){
        try {
            Scanner originalFile = new Scanner(new File("OutPutFileCheckHere/originalOutPutModel.txt"));
            Scanner generatedOutPut =new Scanner(new File("OutPutFileCheckHere/output.txt"));
            while (originalFile.hasNextLine()){
                assertEquals(originalFile.nextLine(),generatedOutPut.nextLine());
            }
            originalFile.close();
            generatedOutPut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}