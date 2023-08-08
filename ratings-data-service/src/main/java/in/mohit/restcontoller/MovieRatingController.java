package in.mohit.restcontoller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.mohit.model.Rating;
import in.mohit.model.UserRating;

@RestController
@RequestMapping(value = "/ratingsData")
public class MovieRatingController {
	
	@GetMapping(value = "/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId, 3);
	}
	
	@GetMapping(value = "/users/{userId}")
	public UserRating getRatings(@PathVariable String userId) {
		
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 3),
				new Rating("5678",4)
				);
		UserRating userRatings = new UserRating();
		userRatings.setUserRating(ratings);
		return userRatings;
	}
}
