package ug.dbelgrau.main.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ug.dbelgrau.main.domain.Gpu;
import ug.dbelgrau.main.service.GpuService;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/gpu")
public class GpuController {

    @Autowired
    private final GpuService gpuService;

    @GetMapping("")
    public ResponseEntity<List<Gpu>> searchGpus(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "minPrice", required = false) Integer minPrice,
            @RequestParam(name = "maxPrice", required = false) Integer maxPrice,
            @RequestParam(name = "minDate", required = false) LocalDate minDate,
            @RequestParam(name = "maxDate", required = false) LocalDate maxDate,
            @RequestParam(name = "available", required = false) Boolean available) {

        List<Gpu> result = gpuService.searchGpus(name, minPrice, maxPrice, minDate, maxDate, available);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Gpu> addGPU(@RequestBody Gpu gpu, UriComponentsBuilder uriBuilder) {
        Gpu addedGPU = gpuService.addGpu(gpu);

        String uriString = uriBuilder.path("/api/gpu/{id}").buildAndExpand(addedGPU.getId()).toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(uriString));

        return new ResponseEntity<>(addedGPU, headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gpu> getGpuById(@PathVariable Long id) {
        Optional<Gpu> gpuOptional = gpuService.findGpu(id);

        return gpuOptional.map(gpu -> new ResponseEntity<>(gpu, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gpu> updateGpu(@PathVariable Long id, @RequestBody Gpu updatedGpu) {
        updatedGpu.setId(id);
        Gpu savedGpu = gpuService.updateGpu(updatedGpu);

        if (savedGpu != null) {
            return new ResponseEntity<>(savedGpu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGpu(@PathVariable Long id) {
        gpuService.deleteGpu(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
