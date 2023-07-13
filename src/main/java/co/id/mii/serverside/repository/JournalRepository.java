package co.id.mii.serverside.repository;

import java.util.Optional;
import co.id.mii.serverside.model.Journal;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long>{
    Optional<Journal> findByName(String name);
}
    
