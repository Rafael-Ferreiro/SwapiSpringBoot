package entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

	private Long count;
	// Creating HashMap
	private ArrayList<People> results;

	public Result() {
		// TODO Auto-generated constructor stub
		results = new ArrayList<People>();
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long valor) {
		this.count = valor;
	}

	public ArrayList<People> getResults() {
		return results;
	}

	public void setResults(ArrayList<People> valor) {
		this.results = valor;

	}

}
