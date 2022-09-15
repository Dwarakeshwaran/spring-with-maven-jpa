package dwaki.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwaki.entity.AnimeEntity;
import dwaki.model.Anime;
import dwaki.repository.AnimeRepo;

@Service
public class AnimeService {

	@Autowired
	public AnimeRepo animeRepo;

	private static final Logger logger = LoggerFactory.getLogger(AnimeService.class);

	public void check() {
		logger.info("Inside AnimeService...");
	}

	public void saveAnime(Anime anime) {

		ModelMapper mapper = new ModelMapper();

		AnimeEntity animeEntity = mapper.map(anime, AnimeEntity.class);

		animeRepo.save(animeEntity);

		logger.info("{} saved to DB...", anime);

	}

}
