package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import entities.PersonInfo;
import services.ApiService;

@RestController
public class PersonController {

	@Autowired
	 private ApiService servicio;
	

	@RequestMapping("/swapi-proxy/person-info")
	public ResponseEntity<String> findPeople(@RequestParam(value = "name", defaultValue = "") String name) {

		try {

			if (name.isEmpty())
				return new ResponseEntity<String>("O campo name esta vacio.", HttpStatus.NOT_FOUND);
			PersonInfo response = servicio.SendtoApi(name);
			if (response.getName() == null)
				return new ResponseEntity<String>("Non existe ninguén con ese nome.", HttpStatus.NOT_FOUND);
			return new ResponseEntity<String>(response.toString(), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
}