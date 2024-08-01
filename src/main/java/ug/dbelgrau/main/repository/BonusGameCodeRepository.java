package ug.dbelgrau.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ug.dbelgrau.main.domain.BonusGameCode;

@Repository
public interface BonusGameCodeRepository extends JpaRepository<BonusGameCode, Long> {
}
