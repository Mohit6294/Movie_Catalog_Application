package in.mohit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalgItem {
	
	private String name;
	private String desc;
	private int rating;
}
