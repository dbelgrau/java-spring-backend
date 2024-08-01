package ug.dbelgrau.main.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ug.dbelgrau.main.domain.Architecture;
import ug.dbelgrau.main.domain.Cpu;
import ug.dbelgrau.main.domain.Gpu;
import ug.dbelgrau.main.repository.ArchitectureRepository;
import ug.dbelgrau.main.repository.GpuRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class GpuService {

    private final GpuRepository gpuRepository;

    public List<Gpu> getAll() {
        return gpuRepository.findAll();
    }

    public Gpu addGpu(Gpu gpu) {
        return gpuRepository.save(gpu);
    }

    public Optional<Gpu> findGpu(Long id) {
        return gpuRepository.findById(id);
    }

    public void deleteGpu(Long id) {
        gpuRepository.deleteById(id);
    }

    public List<Gpu> findGpusByAvailability(boolean available) {
        return gpuRepository.findGpusByAvailabilityNative(available);
    }

    public Gpu updateGpu(Gpu updatedGpu) {
        return gpuRepository.save(updatedGpu);
    }

    public List<Gpu> searchGpus(String name, Integer minPrice, Integer maxPrice, LocalDate minDate, LocalDate maxDate, Boolean available) {
         return gpuRepository.findBySearchParams(name, minPrice, maxPrice, minDate, maxDate, available);
    }
}
