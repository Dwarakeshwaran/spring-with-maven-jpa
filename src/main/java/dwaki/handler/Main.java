package dwaki.handler;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.Logger;
import dwaki.model.Anime;
import dwaki.service.AnimeService;

@Configuration
@ComponentScan(basePackages = "dwaki.*")
public class Main {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		logger.info("Inside Main...");
		ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		AnimeService service = context.getBean(AnimeService.class);
		service.check();

		// save an Anime
		Anime anime = new Anime("Hunter × Hunter", "Gon", 2011, 50, 98);
		service.saveAnime(anime);

		((AnnotationConfigApplicationContext) context).close();
	}

	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
