import static java.util.stream.Collectors.
toList;
import java.util.Comparator;
import java.util.stream.IntStream;

import java.util.List;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


class Strelab1 {
	



public static void main(String[] args) {
CountryDao countryDao = InMemoryWorldDao.getInstance ();
CityDao cityDao = InMemoryWorldDao.getInstance ();
Optional<City> capital = countryDao. findAllCountries ()
.stream () 
.map (Country::getCapital) 
.map (cityDao::findCityById) 
.filter (Objects::nonNull)
.collect(toList()).stream().max(Comparator.comparing (City::getPopulation));
capital.ifPresent (System.out::println);

 } }