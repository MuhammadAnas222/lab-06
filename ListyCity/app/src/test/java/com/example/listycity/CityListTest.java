package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    void testhasCity() {
        CityList cityList = mockCityList();

        // Test that mockCity (edmonton) exists
        City edmonton = mockCity();
        assertTrue(cityList.hasCity(edmonton));

        // Test that a non-existent city returns false
        City calgary = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(calgary));

        // Adding Calgary and testing again
        cityList.add(calgary);
        assertTrue(cityList.hasCity(calgary));
    }
    @Test
    void testRemove() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");
        cityList.add(city);

        // Verifying that the city was added
        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(city));

        // Deleting the city
        cityList.delete(city);

        // Verifying that the city was removed
        assertEquals(1, cityList.countCities());
        assertFalse(cityList.hasCity(city));
    }
    @Test
    void testRemoveException() {
        CityList cityList = mockCityList();
        City city = new City("Toronto", "Ontario");

        // City was never added, so calling delete() should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }
    @Test
    void testcountCities() {
        CityList cityList = mockCityList();

        // Initially it should be empty
        cityList.delete(mockCity());
        assertEquals(0, cityList.countCities());

        // Adding one city and checking count
        cityList.add(mockCity());
        assertEquals(1, cityList.countCities());

        // Adding more cities and checking count
        cityList.add(new City("Calgary", "Alberta"));
        cityList.add(new City("Montreal", "Quebec"));
        assertEquals(3, cityList.countCities());

        // Deleting one city and checking count
        cityList.delete(mockCity());
        assertEquals(2, cityList.countCities());
    }
}
