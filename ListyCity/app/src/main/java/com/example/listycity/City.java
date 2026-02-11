package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable {
    /**
     * This is a String variable which stores city name
     */
    private String city;
    /**
     * This is a String variable which stores province name
     */
    private String province;
    /**
     * This is a constructor that takes in string values (city and province) to make a city object.
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    /**
     * This is a method that returns a City.
     */
    String getCityName(){
        return this.city;
    }
    /**
     * This is a method that returns a Province.
     */
    String getProvinceName(){
        return this.province;
    }
    /**
     * Compares this city with another city object based on city names
     * @param o
     *      The object to be compared
     * @return
     *      A negative integer, zero, or a positive integer as this city's name
     *      is less than, equal to, or greater than the specified city's name
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
    /**
     * Checks if this city is equal to another object.
     * Two cities are considered equal if they have the same city name and province name.
     * @param obj
     *      The object to compare with
     * @return
     *      true if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        City other = (City) obj;
        return this.city.equals(other.city) && this.province.equals(other.province);
    }
    /**
     * Returns a hash code value for this city.
     * @return
     *      A hash code value based on city name and province
     */
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + province.hashCode();
        return result;
    }
}