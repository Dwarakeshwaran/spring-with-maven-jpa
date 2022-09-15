package dwaki.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "my_anime_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AnimeEntity.class)
public class AnimeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "my_anime_info_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "my_anime_info_id_seq", sequenceName = "my_anime_info_id_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "anime_name")
	private String animeName;

	@Column(name = "protagonist_name")
	private String protagonistName;

	@Column(name = "year")
	private Integer year;

	@Column(name = "power")
	private Integer power;

	@Column(name = "rating")
	private Integer rating;

}
