package in.mohit.restcontroller;

import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.mohit.model.Movie;

@RestController
@RequestMapping(value = "/movies")
public class MovieInfoController {
	
	@GetMapping(value = "/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		return new Movie(movieId, "Test name");
		
	}
}
