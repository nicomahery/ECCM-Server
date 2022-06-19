package fr.hiapoe.eccmserver.eccmserver.repositories;

import fr.hiapoe.eccmserver.eccmserver.entities.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TripRepository extends PagingAndSortingRepository<Trip, String> {
    @Query("SELECT t.id from trip t")
    List<String> getAllId();
}
