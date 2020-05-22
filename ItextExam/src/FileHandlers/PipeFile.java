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
    protected void parseString(String lineToParse) {
        this.dataSplit = lineToParse.split(this.delimiter);
        Person person = new Person();
        person.setLastName(dataSplit[0].trim());
        person.setFirstName(dataSplit[1].trim());
        person.setGender(dataSplit[3].trim());
        person.setColor(dataSplit[4].trim());
        person.setDob(dataSplit[5].trim().replaceAll("-","/"));
        this.personMap.put(person.getLastName(),person);
    }
}
