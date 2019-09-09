package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import entities.HttpErrorResponse;
import entities.PersonInfo;
import services.ApiService;

@RestController
public class PersonController {

	@Autowired
	 private ApiService servicio;
	
	@Value("${error.text.emptyname}")
	private String emptyname;
	
	@Value("${error.text.notexistname}")
	private String notexistname;
	

	@RequestMapping("/swapi-proxy/person-info")
	public ResponseEntity<?> findPeople(@RequestParam(value = "name", defaultValue = "") String name) {

		try {
			HttpHeaders headers = new HttpHeaders();
		      headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

			if (name.isEmpty()) {
				HttpErrorResponse error = new HttpErrorResponse();
				error.setMessage(emptyname);
				return new ResponseEntity<HttpErrorResponse>(error,headers, HttpStatus.NOT_FOUND);
			}
				
			PersonInfo response = servicio.SendtoApi(name);
			if (response.getName() == null) {
				HttpErrorResponse error = new HttpErrorResponse();
				error.setMessage(notexistname);
				return new ResponseEntity<HttpErrorResponse>(error,headers, HttpStatus.NOT_FOUND);
			}				
			return new ResponseEntity<PersonInfo>(response,headers, HttpStatus.OK);

		} catch (Exception e) {
			
			HttpHeaders headers = new HttpHeaders();
		      headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		      HttpErrorResponse error = new HttpErrorResponse();
				error.setMessage(e.toString());
			return new ResponseEntity<HttpErrorResponse>(error,headers, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
}