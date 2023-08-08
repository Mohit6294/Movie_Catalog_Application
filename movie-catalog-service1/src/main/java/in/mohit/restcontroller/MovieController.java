package in.mohit.restcontroller;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.catalina.filters.AddDefaultCharsetFilter.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import in.mohit.model.CatalgItem;
import in.mohit.model.Movie;
import in.mohit.model.Rating;
import in.mohit.model.UserRating;

@RestController
@RequestMapping(value = "/catalog")
public class MovieController{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient rBuilder;
	
	@GetMapping("/{userId}")
	public List<CatalgItem> getCatalgItems(@PathVariable String userId){
		
		
	  UserRating userRatings=	restTemplate.getForObject("http://localhost:8082/ratingsData/users/"+userId,UserRating.class);
	  
	  List<Rating> ratings = userRatings.getUserRating();
		 
		
		return ratings.stream()
				.map(rating-> {
				//Movie movie =restTemplate.getForObject(", Movie.class);
			 Movie movie=	restTemplate.getForObject("http://localhost:8081/movies/"+rating.getMovieId(), Movie.class);
					
					return new CatalgItem(movie.getName(), "Desc", rating.getRating());
				})
				.collect(Collectors.toList());
		
		//return Stream.of(new CatalgItem("Transformers", "Test", 3)).toList();
	}
}
