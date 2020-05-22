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
        SpaceFile spaceFile = new SpaceFile("TextFiles/space.txt"," "); // MyClass is tested
        HashMap<String,Person> mp = spaceFile.getPersonMap();
        assertEquals(mp.get("Kournikova").toString(),"Kournikova Anna Female 6/3/1975 Red");
        assertEquals(mp.get("Hingis").toString(),"Hingis Martina Female 4/2/1979 Green");
        assertEquals(mp.get("Seles").toString(),"Seles Monica Female 12/2/1973 Black");
    }
    /**
     * checks the data retrieved from the pipe
     * file to make sure it is in correct format
     * */
    @Test
    public void checkPipeFileEntries(){
        PipeFile pipeFile= new PipeFile("TextFiles/pipe.txt","\\|");
        HashMap<String,Person> mp = pipeFile.getPersonMap();
        assertEquals(mp.get("Smith").toString(),"Smith Steve Male 3/3/1985 Red");
        assertEquals(mp.get("Bonk").toString(),"Bonk Radek Male 6/3/1975 Green");
        assertEquals(mp.get("Bouillon").toString(),"Bouillon Francis Male 6/3/1975 Blue");
    }
    /**
     * checks the data retrieved from the comma
     * file to make sure it is in correct format
    * */
    @Test
    public void checkCommaFileEntries(){
        CommaFile commaFile = new CommaFile("TextFiles/comma.txt",",");
        HashMap<String,Person> mp = commaFile.getPersonMap();
        assertEquals(mp.get("Abercrombie").toString(),"Abercrombie Neil Male 2/13/1943 Tan");
        assertEquals(mp.get("Bishop").toString(),"Bishop Timothy Male 4/23/1967 Yellow");
        assertEquals(mp.get("Kelly").toString(),"Kelly Sue Female 7/12/1959 Pink");
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