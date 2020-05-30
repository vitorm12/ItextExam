package com.company;

import FileHandlers.FileHandler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Vitor Mouzinho
 * @date 5/30/2020
 * This class is used to help sort and merge lists
 *
* */
public class SortAndMergeLists {
    /*LinkedList of male entries*/
    LinkedList<Person> maleList;
    /*Linked list of female entries*/
    LinkedList<Person> femaleList;
    /*Merged list of both female and male*/
    LinkedList<Person> mergedList;

    /**
     * @param pipe the pipe file data
     * @param comma the comma file data
     * @param  space the space file data
     *  initializes, assigns and merges LinkedLists
    * */
    SortAndMergeLists(FileHandler pipe, FileHandler comma, FileHandler space){
        this.maleList = mergeLists(pipe.getMaleEntries(),comma.getMaleEntries(),space.getMaleEntries());
        this.femaleList = mergeLists(pipe.getFemaleEntries(),comma.getFemaleEntries(),space.getFemaleEntries());
        this.mergedList = new LinkedList<>();
        this.mergedList.addAll(femaleList);
        this.mergedList.addAll(maleList);
    }
    /**
     * @param pipe LinkedList of a Person object
     * @param comma LinkedList of a Person object
     * @param space LinkedList of a Person object
     * @return mergedList a merge of LinkedLists
     * merges LinkedLists
    * */
    private LinkedList<Person> mergeLists(LinkedList<Person> pipe,LinkedList<Person> comma,LinkedList<Person> space){
        LinkedList<Person> mergeList = new LinkedList<Person>();
        mergeList.addAll(space);
        mergeList.addAll(pipe);
        mergeList.addAll(comma);
        return mergeList;
    }
    /**
     * @return mergedList sorted by birthdays
     * This method is used to sort LinkedList by birthdays
     * if the birthday equal will sort by last name.
    * */
    public LinkedList<Person> sortByBirthday(){
            Collections.sort(this.mergedList, (personOne, personTwo) -> {
                Date yearOfPTwo=null;
                Date yearOfPOne = null;
                try {
                    yearOfPOne = new SimpleDateFormat("MM/dd/yyyy").parse(personOne.getDob());
                    yearOfPTwo = new SimpleDateFormat("MM/dd/yyyy").parse(personTwo.getDob());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int comapreResults = yearOfPOne.compareTo(yearOfPTwo);
                if( 0== comapreResults){
                    return personOne.getLastName().compareTo(personTwo.getLastName());
                }
                return comapreResults;
            });
        return this.mergedList;
    }
    /**
     * @param list LinkedList of person objects to sort
     * @param reverse states if the sort will be ascending or descending order
     * @return list the sorted list
     * This method will reverse LinkedList of person objects
     * by their last name can either sort by descending or ascending order
    * */
   public LinkedList<Person> sortByName(LinkedList<Person> list,boolean reverse){
        Collections.sort(list, Comparator.comparing(Person::getLastName));
        if (reverse){
             Collections.reverse(list);
        }
        return list;
    }


}
