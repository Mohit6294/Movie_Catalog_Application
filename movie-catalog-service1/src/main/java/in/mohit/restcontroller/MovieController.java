package in.mohit.restcontroller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.mohit.model.CatalgItem;

@RestController
@RequestMapping(value = "/catalog")
public class MovieController{
	
	@GetMapping("/{userId}")
	public List<CatalgItem> getCatalgItems(@PathVariable String userId){
		
		
		return Stream.of(new CatalgItem("Transformers", "Test", 3)).toList();
	}
}
