package ug.dbelgrau.main.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters")
    private String name;

    @Min(value = 1, message = "Generation must be at least 1")
    @Max(value = 99, message = "Generation cannot exceed 99")
    private int generation;

    @ManyToMany(mappedBy = "cpus", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Gpu> gpus;
}
