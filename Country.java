//content://com.whatsapp.provider.media/item/5f46e8b6-ce9b-44df-b586-bcec167f6acc
import java.util.ArrayList;
import java.util.*;
class Country{
	private String code;
	private String name;
	private String continent;
	private double surfaceArea;
	private int population;
	private double gnp;
	private int capital ;
	private List<City> cities;
	{ cities = new ArrayList<>();}
	
	public Country(){}
	public Country(String code , String name,String continent,int population,double surfaceArea,double gnp,int capital){
		this.code = code;
		this.name = name;
		this.continent=continent;
		this.surfaceArea=surfaceArea;
		this.population=population;
		this.capital=capital;
		this.gnp=gnp;
	} 
	public String getCode(){return code;}
	public void setCode(String code){this.code = code;}
    public String getName(){return name;}
	public void setName(String name){this.name = name;}
	public int getPopulation(){return population;}
	public void setPopulation(int population){this.population = population;}
	public String getcontinent(){return continent;}
    public void setcontinent(String continent){this.continent = continent;}
	public double getsurfaceArea(){return surfaceArea;}
	public void setsurfaceArea(double surfaceArea){this.surfaceArea = surfaceArea;}
	public int getcapitall(){return capital;}
	public void setcapitall(int capital){this.capital=capital;}
	public double getcapital(){return gnp;}
	public void setcapital(double gnp){this.gnp=gnp;}
	public List<City>getCities(){return cities;}
	public void setCities(List<City>cities){this.cities = cities;}
	}