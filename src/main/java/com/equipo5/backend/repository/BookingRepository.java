package com.equipo5.backend.repository;

import com.equipo5.backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByOwnersId(Long ownerId);
    //Optional<Booking> findBySitterId(Long sitterId);
    @Query("SELECT b FROM Booking b WHERE (:startTime < b.endTime AND :endTime > b.startTime) AND b.status = true")
    List<Booking> findConflictsBookings(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}
