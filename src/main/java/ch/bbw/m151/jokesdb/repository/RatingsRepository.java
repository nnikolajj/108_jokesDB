package ch.bbw.m151.jokesdb.repository;

import ch.bbw.m151.jokesdb.datamodel.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<RatingEntity, Integer> {
}
