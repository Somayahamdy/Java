//content://com.whatsapp.provider.media/item/512399bd-0b0c-4f32-bd86-427cd82ef4e9

import java.util.ArrayList;
import java.util.*;
class City{
	private int id;
	private String name;
	private int population;
	private String countrycode;
	public City(){}
		
	public City(int id ,String name ,String countrycode,int population){
		this.id = id;
		this.name = name;
		this.population = population;
		this.countrycode=countrycode;
	}
	public int getId(){return id;}
	public void setId(int id ){ this.id =id;}
	public String getName(){return name;}
	public void setName(String name){this.name = name;}
	public int getPopulation(){return population;}
	public  void setPopulation(int population){this.population = population;}
	public String getCountrycode(){return countrycode;}
	public void setCountrycode(String countrycode){this.countrycode = countrycode;}
	@Override
	public String toString(){
	return name + " , "+population+ " , " +countrycode;
	}
	
}