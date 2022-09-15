package dwaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dwaki.entity.AnimeEntity;

@Repository
public interface AnimeRepo extends JpaRepository<AnimeEntity, Long>{

}
