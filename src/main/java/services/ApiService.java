package services;

import java.util.ArrayList;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import entities.Film;
import entities.PersonInfo;
import entities.Planet;
import entities.Result;
import entities.Root;
import entities.Vehicle;

@Service("ApiService")
public class ApiService {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private final String urlRoot = "https://swapi.co/api/";

	@Autowired
	private RestTemplate restClient;

	public ApiService() {

	}

	public PersonInfo SendtoApi(String name) {

		RestTemplate restTemplate = new RestTemplate();
		PersonInfo personInfo = new PersonInfo();

		ResponseEntity<Result> response = restTemplate.exchange(getRoot(), HttpMethod.GET, getHttpEntity(),
				Result.class);
		response.getBody().getResults().forEach((p) -> {
			if (p.getName().contains(name)) {
				personInfo.setName(p.getName());
				personInfo.setGender(p.getGender());
				personInfo.setBirth_year(p.getBirth_year());
				personInfo.setHomeworld(getPlanet(p.getHomeworld()));
				ArrayList<Film> filmsResult = new ArrayList<Film>();
				p.getFilms().forEach((film) -> {
					filmsResult.add(getFilm(film));
				});
				personInfo.setFilms(filmsResult);
				personInfo.setMax_atmosphering_speed(getFastestVehicleDriven(p.getVehicles(), p.getstarships()));
			}
		});
		return personInfo;

	}

	public Film getFilm(String url) {

		ResponseEntity<Film> response = restClient.exchange(url, HttpMethod.GET, getHttpEntity(), Film.class);
		return response.getBody();

	}

	public Vehicle getVehicle(String url) {

		ResponseEntity<Vehicle> response = restClient.exchange(url, HttpMethod.GET, getHttpEntity(), Vehicle.class);
		return response.getBody();
	}

	public Vehicle getStarship(String url) {

		ResponseEntity<Vehicle> response = restClient.exchange(url, HttpMethod.GET, getHttpEntity(), Vehicle.class);
		return response.getBody();

	}

	public String getPlanet(String url) {

		ResponseEntity<Planet> response = restClient.exchange(url, HttpMethod.GET, getHttpEntity(), Planet.class);
		return response.getBody().getName().toString();

	}

	public String getFastestVehicleDriven(ArrayList<String> vehicle, ArrayList<String> startship) {

		Long maximalSpeed = 0L;
		Long tempSpeed = 0L;
		Vehicle maximalVehicle = new Vehicle("Ninguno", 0L);
		for (String temp : vehicle) {
			Vehicle tempVehicle = getVehicle(temp);
			tempSpeed = tempVehicle.getMax_atmosphering_speed();
			if (tempSpeed > maximalSpeed) {
				maximalSpeed = tempSpeed;
				maximalVehicle = tempVehicle;
			}
		}
		for (String temp : startship) {
			Vehicle tempVehicle = getStarship(temp);
			tempSpeed = tempVehicle.getMax_atmosphering_speed();
			if (tempSpeed > maximalSpeed) {
				maximalSpeed = tempSpeed;
				maximalVehicle = tempVehicle;
			}
		}
		return maximalVehicle.getName().toString();
	}

	public HttpEntity<String> getHttpEntity() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		return new HttpEntity<String>("parameters", headers);

	}

	public String getRoot() {

		ResponseEntity<Root> response = restClient.exchange(urlRoot, HttpMethod.GET, getHttpEntity(), Root.class);
		return response.getBody().getPeople();
	}

}
