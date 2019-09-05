package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Film {

    @Override
	public String toString() {
		return "Film [title=" + title + ", release_date=" + release_date + "]";
	}

	private String title;
    private String release_date;

    public Film() { }

	public String getTitle() {
		return title;
	}

	public String getRelease_date() {
		return release_date;
	}

   
}
