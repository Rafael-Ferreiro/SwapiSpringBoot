package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpErrorResponse {

	public HttpErrorResponse() {
		// TODO Auto-generated constructor stub
	}
	private String message;
	
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "HttpErrorResponse [message=" + message + "]";
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
