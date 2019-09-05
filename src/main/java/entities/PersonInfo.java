package entities;

import java.util.ArrayList;

public class PersonInfo {

	private String name;
	private String birth_year;
	private String gender;
	private String homeworld;
	private ArrayList<Film> films;
	private  String max_atmosphering_speed;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth_year() {
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

	public ArrayList<Film> getFilms() {
		return films;
	}

	@Override
	public String toString() {
		return "PersonInfo [name=" + name + ", birth_year=" + birth_year + ", gender=" + gender + ", homeworld="
				+ homeworld + ", films=" + films + ", max_atmosphering_speed=" + max_atmosphering_speed + "]";
	}

	public void setFilms(ArrayList<Film> films) {
		this.films = films;
	}

	public String getMax_atmosphering_speed() {
		return max_atmosphering_speed;
	}

	public void setMax_atmosphering_speed(String max_atmosphering_speed) {
		this.max_atmosphering_speed = max_atmosphering_speed;
	}

	public PersonInfo() {
		// TODO Auto-generated constructor stub
	}

}
