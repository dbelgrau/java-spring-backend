package ug.dbelgrau.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ug.dbelgrau.main.domain.Gpu;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface GpuRepository extends JpaRepository<Gpu, Long> {

    @Override
    Optional<Gpu> findById(Long id);

    @Query(value = "SELECT * FROM gpu WHERE available = :available", nativeQuery = true)
    List<Gpu> findGpusByAvailabilityNative(@Param("available") boolean available);

    @Query("SELECT g FROM Gpu g " +
            "LEFT JOIN FETCH g.architecture " +
            "LEFT JOIN FETCH g.cpus " +
            "LEFT JOIN FETCH g.bonusGameCode " +
            "WHERE " +
            "(:name IS NULL OR g.name = :name) AND " +
            "(:minPrice IS NULL OR g.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR g.price <= :maxPrice) AND " +
            "(:minDate IS NULL OR g.releaseDate >= :minDate) AND " +
            "(:maxDate IS NULL OR g.releaseDate <= :maxDate) AND " +
            "(:available IS NULL OR g.available = :available)")
    List<Gpu> findBySearchParams(
            @Param("name") String name,
            @Param("minPrice") Integer minPrice,
            @Param("maxPrice") Integer maxPrice,
            @Param("minDate") LocalDate minDate,
            @Param("maxDate") LocalDate maxDate,
            @Param("available") Boolean available);

}
