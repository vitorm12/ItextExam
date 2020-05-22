package FileHandlers;

import com.company.Person;

/**
 * @author Vitor Mouzinho
 * date: 05/22/2020
 * This class is used to handle
 * */
public class SpaceFile extends FileHandler {

    public SpaceFile(String fileName, String delimiter) {
        super(fileName, delimiter);
    }


    @Override
    protected void parseString(String lineToParse) {
        this.dataSplit = lineToParse.split(this.delimiter);
        Person person = new Person();
        person.setLastName(this.dataSplit[0]);
        person.setFirstName(this.dataSplit[1]);
        person.setGender(this.dataSplit[3]);
        person.setColor(this.dataSplit[5]);
        person.setDob(this.dataSplit[4].replaceAll("-", "/"));
        this.personMap.put(person.getLastName().trim(), person);
    }

}
