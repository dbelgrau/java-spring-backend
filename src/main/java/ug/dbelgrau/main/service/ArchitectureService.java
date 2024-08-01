package ug.dbelgrau.main.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ug.dbelgrau.main.domain.Architecture;
import ug.dbelgrau.main.repository.ArchitectureRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ArchitectureService {
    private final ArchitectureRepository architectureRepository;

    public List<Architecture> getAll() {
        return architectureRepository.findAll();
    }

    public Architecture addArchitecture(Architecture architecture) {
        return architectureRepository.save(architecture);
    }

    public Optional<Architecture> findArchitecture(Long id) {
        return architectureRepository.findById(id);
    }

    public Architecture updateArchitecture(Architecture architecture) {
        return architectureRepository.save(architecture);
    }

    public void deleteArchitecture(Long id) {
        architectureRepository.deleteById(id);
    }
}
