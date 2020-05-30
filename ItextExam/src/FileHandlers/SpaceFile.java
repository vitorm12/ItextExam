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
    protected Person parseString(String lineToParse) {
        this.dataSplit = lineToParse.split(this.delimiter);
        return new Person(this.dataSplit[0],this.dataSplit[1],this.dataSplit[3],this.dataSplit[4].replaceAll("-", "/"),this.dataSplit[5]);
    }

}
