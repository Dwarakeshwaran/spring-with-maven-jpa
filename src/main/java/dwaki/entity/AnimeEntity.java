package dwaki.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "my_anime_info")
@Data
public class AnimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Id
	@Column(name = "anime_name")
	private String animeName;

	@Id
	@Column(name = "protagonist_name")
	private String protagonistName;

	@Id
	@Column(name = "year")
	private int year;

	@Id
	@Column(name = "power")
	private int power;

	@Id
	@Column(name = "rating")
	private int rating;

}
