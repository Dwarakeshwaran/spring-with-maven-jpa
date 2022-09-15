package dwaki.model;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Component
@Data
@ToString
public class Anime {
	
	private int id;
	private String animeName;
	private String protagonistName;
	private int year;
	private int power;
	private int rating;

}
