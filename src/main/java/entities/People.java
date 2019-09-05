package entities;


import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class People {

	private String name;
	private String birth_year;
	private String gender;
	private String homeworld;
	private ArrayList<String> films;
	private ArrayList<String> vehicles;
	private ArrayList<String> starships;

	public String personInfo() {
		return birth_year;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	public ArrayList<String> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<String> vehicles) {
		this.vehicles = vehicles;
	}

	public ArrayList<String> getstarships() {
		return starships;
	}

	public void setStarships(ArrayList<String> starships) {
		this.starships = starships;
	}


	public ArrayList<String> getFilms() {
		return films;
	}

	public void setFilms(ArrayList<String> films) {
		this.films = films;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public People() {

	}

	

	@Override
	public String toString() {
		return "People [name=" + name + ", birth_year=" + birth_year + ", gender=" + gender + ", homeworld=" + homeworld
				+ ", films=" + films + ", vehicles=" + vehicles + ", starships=" + starships + "]";
	}

	public String getBirth_year() {
		return birth_year;
	}

	
}
