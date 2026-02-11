package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    /**
     * This is a list which holds a list of city objects
     */
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *      This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    /**
     * This returns True if a city belongs in the list else False
     * @param city
     *      This is the candidate city to search for
     * @return
     *      Return True or False
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }
    /**
     * This deletes a city from the list if the city exists
     * @param city
     *      This is a candidate city to delete
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }
    /**
     * This returns the number of cities in the list
     * @return
     *      Return the integer number
     */
    public int countCities() {
        return cities.size();
    }
}