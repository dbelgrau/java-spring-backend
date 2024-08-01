package ug.dbelgrau.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ug.dbelgrau.main.domain.Architecture;

@Repository
public interface ArchitectureRepository extends JpaRepository<Architecture, Long> {
}
