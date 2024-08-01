package ug.dbelgrau.main.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ug.dbelgrau.main.domain.Architecture;
import ug.dbelgrau.main.domain.Gpu;
import ug.dbelgrau.main.service.ArchitectureService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/architecture")
public class ArchitectureController {
    @Autowired
    private final ArchitectureService architectureService;

    @GetMapping
    ResponseEntity<List<Architecture>> getAll() {
        return new ResponseEntity<>(architectureService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Architecture> addArchitecture(@RequestBody Architecture architecture, UriComponentsBuilder uriBuilder) {
        Architecture addedArchitecture = architectureService.addArchitecture(architecture);

        String uriString = uriBuilder.path("/api/architecture/{id}").buildAndExpand(addedArchitecture.getId()).toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(uriString));

        return new ResponseEntity<>(addedArchitecture, headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Architecture> getArchitectureById(@PathVariable Long id) {
        Optional<Architecture> architectureOptional = architectureService.findArchitecture(id);

        return architectureOptional.map(architecture -> new ResponseEntity<>(architecture, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Architecture> updateArchitecture(@PathVariable Long id, @RequestBody Architecture updatedArchitecture) {
        updatedArchitecture.setId(id);
        Architecture savedArchitecture = architectureService.updateArchitecture(updatedArchitecture);

        if (savedArchitecture != null) {
            return new ResponseEntity<>(savedArchitecture, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArchitecture(@PathVariable Long id) {
        architectureService.deleteArchitecture(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
