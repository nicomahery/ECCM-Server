package fr.hiapoe.eccmserver.eccmserver.repositories;

import fr.hiapoe.eccmserver.eccmserver.entities.CarLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CarLogRepository extends JpaRepository<CarLog, LocalDateTime> {
    List<CarLog> findAllByTripIdOrderByDeviceTime(String tripId);
    @Query("SELECT c.tripId from car_log c GROUP BY c.tripId")
    List<String> getAllTripId();
    @Query(nativeQuery = true,
            value = "SELECT * FROM car_log c WHERE c.trip_id = :tripId AND c.gps_latitude IS NOT NULL AND c.gps_longitude IS NOT NULL ORDER BY c.device_time DESC LIMIT 1")
    Optional<CarLog> getLastCarLogWithCoordinatesByTripId(String tripId);
    @Query(nativeQuery = true,
            value = "SELECT * FROM car_log c WHERE c.trip_id = :tripId AND c.gps_latitude IS NOT NULL AND c.gps_longitude IS NOT NULL ORDER BY c.device_time LIMIT 1")
    Optional<CarLog> getFirstCarLogWithCoordinatesByTripId(String tripId);
}
