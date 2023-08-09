package in.mohit.restcontroller;

import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.mohit.model.Movie;
import in.mohit.model.MovieSummary;




@RestController
@RequestMapping(value = "/movies")
public class MovieInfoController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.key}")
	public String apiKey;
	
	@GetMapping(value = "/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		
		 MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
		 return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
		
	}
}
