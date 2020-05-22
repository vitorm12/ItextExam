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
     *
     *This is a constructor which takes in the information parsed of an entry from the file
     * and assigns is to its corresponding variables.
    * */
    public Person(String lastName, String firstName, String gender, String dob, String color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.color = color;
    }
    /**
     * empty default constructor
    * */
    public Person() {

    }
    /**
     * @param gender gender of entry
     *
     * This method sets the gender of the specific entry
    * */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * @param dob date of birth of entry
     *
     * sets the date of birth for specific entry
    * */
    public void setDob(String dob) {
        this.dob = dob;
    }
    /**
     * @param color color of the specific entry
     * Sets the specific color of the entry
    * */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * @return lastName
     * returns the last name of the entry
    * */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName last name of the specific entry
     *
     *Sets the last name of the specific entry
    * */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @param firstName first name of the specific entry
     *
     * sets the first name of the specific entry
    * */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * This method overrides the toString method of the object
     * This will format the entry to the correct format so it can
     * be written to the file.
    * */
    @Override
    public String toString() {
        if (gender.equals("F")) {
            this.gender = "Female";
        } else if (gender.equals("M")) {
            this.gender = "Male";
        }
        return (lastName + " " + firstName + " " + gender + " " + dob.replaceAll("-", "/") + " " + color + "\n").trim().replaceAll(" +", " ");
    }
}
