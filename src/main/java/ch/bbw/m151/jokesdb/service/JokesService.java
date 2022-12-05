package ch.bbw.m151.jokesdb.service;

import java.time.LocalDate;
import java.util.ArrayList;

import ch.bbw.m151.jokesdb.datamodel.JokesEntity;
import ch.bbw.m151.jokesdb.repository.JokesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class JokesService {

	private static final Logger log = LoggerFactory.getLogger(JokesService.class);

	private final JokesRepository jokesRepository;

	public JokesService(JokesRepository jokesRepository) {
		this.jokesRepository = jokesRepository;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void preloadDatabase() {
		ArrayList<JokesEntity> jokes = new ArrayList<>();

		log.info("will load jokes from classpath...");
		RemoteJokesService rjs= new RemoteJokesService();

		for (int i=0; i<50; i++){
			JokesEntity joke = rjs.jotd();
			joke.setTimestamp(LocalDate.now());
			jokes.add(rjs.jotd());

		}

		jokesRepository.saveAll(jokes);
	}
}
