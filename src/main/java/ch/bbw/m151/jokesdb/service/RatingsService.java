package ch.bbw.m151.jokesdb.service;

import ch.bbw.m151.jokesdb.datamodel.JokesEntity;
import ch.bbw.m151.jokesdb.datamodel.RatingEntity;
import ch.bbw.m151.jokesdb.repository.JokesRepository;
import ch.bbw.m151.jokesdb.repository.RatingsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingsService {
    private static final Logger log = LoggerFactory.getLogger(JokesService.class);

    private final RatingsRepository ratingsRepository;
    private final JokesRepository jokesRepository;

    public RatingsService(RatingsRepository ratingsRepository, JokesRepository jokesRepository) {
        this.ratingsRepository = ratingsRepository;
        this.jokesRepository = jokesRepository;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void preloadDatabase() {
        ArrayList<RatingEntity> ratings = new ArrayList<>();

        log.info("will load ratings from classpath...");

        List<JokesEntity> jokes = jokesRepository.findAll();

        for (JokesEntity joke : jokes) {
            RatingEntity rating = new RatingEntity();

            int a = (int) (Math.random()*9+1);

            rating.setRating(a);
            rating.setJokeId(joke.getId());
            ratings.add(rating);

        }

        ratingsRepository.saveAll(ratings);
    }
}
