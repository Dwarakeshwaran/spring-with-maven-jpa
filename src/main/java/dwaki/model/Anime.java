package dwaki.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Anime {

	private String animeName;
	private String protagonistName;
	private Integer year;
	private Integer power;
	private Integer rating;

}
