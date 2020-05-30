package FileHandlers;
import com.company.Person;

/**
 * @author Vitor Mouzinho
 * This class is used primarly to handle infromation from the Comma File
 * */
public class CommaFile extends FileHandler {

    public CommaFile(String fileName, String delimiter) {
        super(fileName, delimiter);
    }
    /**
     * @param lineToParse entry to parse from file
     * This method is used to parse the entries from the commaFile
     * */
    @Override
    protected Person parseString(String lineToParse) {
        this.dataSplit = lineToParse.split(this.delimiter);
        return new Person(this.dataSplit[0],this.dataSplit[1],this.dataSplit[2],this.dataSplit[4].replaceAll("-","/"),this.dataSplit[3]);
    }

}
