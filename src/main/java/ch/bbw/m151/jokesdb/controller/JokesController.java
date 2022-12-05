package ch.bbw.m151.jokesdb.controller;

import java.util.List;
import java.util.stream.Collectors;

import ch.bbw.m151.jokesdb.datamodel.JokesEntity;
import ch.bbw.m151.jokesdb.datamodel.RatingEntity;
import ch.bbw.m151.jokesdb.repository.JokesRepository;
import ch.bbw.m151.jokesdb.repository.RatingsRepository;
import ch.bbw.m151.jokesdb.service.RemoteJokesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class JokesController {

	private JokesRepository repository;
	private RatingsRepository ratingsRepository;

	/**
	 * @param pageable to be called with params `?page=3&size=5`
	 * @return hilarious content
	 */
	@GetMapping("/jokes")
	public List<JokesEntity> getJokes(Pageable pageable) {
		return repository.findAll(pageable)
				.getContent().stream().distinct().collect(Collectors.toList());


	}
}
