package in.mohit.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
	
	private String movieId;
	
	private String title;
	
	private String overview;
}
