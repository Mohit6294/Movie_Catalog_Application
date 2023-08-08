package in.mohit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalgItem {
	
	private String name;
	private String desc;
	private int rating;
}
