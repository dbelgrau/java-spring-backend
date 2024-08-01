package ug.dbelgrau.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ug.dbelgrau.main.domain.Cpu;

@Repository
public interface CpuRepository extends JpaRepository<Cpu, Long> {
}
