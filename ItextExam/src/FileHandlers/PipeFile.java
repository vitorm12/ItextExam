package FileHandlers;


import com.company.Person;

/**
 * @author Vitor Mouzinho
 * date 05/22/20
 * This class is used to handle information from
 * the Pipe file.
 * */
public class PipeFile extends FileHandler {

    public PipeFile(String fileName, String delimiter) {
        super(fileName, delimiter);

    }
    /**
     * @param lineToParse entry from file that will be parsed.
     *
     * This method is override from its parent class(FileHandler)
     * its responsibility is to parse the entry from the pipe file
     * and format the information into the correct format.
     * */
    @Override
    protected Person parseString(String lineToParse) {
        this.dataSplit = lineToParse.split(this.delimiter);

        //String lastName, String firstName, String gender, String dob, String color
        return new Person(this.dataSplit[0],this.dataSplit[1],this.dataSplit[3],dataSplit[5],this.dataSplit[4]);
    }
}
