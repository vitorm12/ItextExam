package com.company;
/**
 * @author Vitor Mouzinho
 * date: 05/22/2020
 * This class is used as an instance of each
 * entry of the file. It is used mostly to store the data from the file and format the string
 * for the output file.
* */
public class Person {
    /*first name of entry*/
    private String firstName;
    /*last name of entry*/
    private String lastName;
    /*Gender of entry*/
    private String gender;
    /*date of birth of entry*/
    private String dob;
    /*color of entry*/
    private String color;
    /**
     * @param lastName last name of entry
     * @param firstName first name of entry
     * @param gender gender of entry
     * @param dob date of birth of entry
     * @param color color of entry
     *This is a constructor which takes in the information parsed of an entry from the file
     * and assigns is to its corresponding variables.
    * */
    public Person(String lastName, String firstName, String gender, String dob, String color) {
        this.firstName = firstName.trim();
        if (gender.trim().equals("F")) {
            this.gender = "Female";
        } else if (gender.trim().equals("M")) {
            this.gender = "Male";
        }else{
            this.gender = gender.trim();
        }
        this.lastName = lastName.trim();
        this.dob = dob.trim().replaceAll("-","/");
        this.color = color.trim();
    }
    /**
     * @return lastName
     * returns the last name of the entry
    * */
    public String getLastName() {
        return lastName;
    }
    /**
     * @return gender
     * returns the gender of the person
    * */
    public String getGender(){
        return gender;
    }
    /**
     * @return dob
     * this returns the dob of the person
    * */
    public String getDob(){
        return this.dob;
    }
    /**
     * This method overrides the toString method of the object
     * This will format the entry to the correct format so it can
     * be written to the file.
     * */
    @Override
    public String toString() {
        return (lastName + " " + firstName + " " + gender + " " + dob+ " " + color).replaceAll(" +", " ");
    }
}
