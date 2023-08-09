package in.mohit.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieSummary {
	
	private String movieId;
	
	private String title;
	
	private String overview;
}
