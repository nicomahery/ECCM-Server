package fr.hiapoe.eccmserver.eccmserver.repositories;

import fr.hiapoe.eccmserver.eccmserver.entities.CarLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarLogRepository extends JpaRepository<CarLog, String> {
}
