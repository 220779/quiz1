package quiz1.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz1.database.entities.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
