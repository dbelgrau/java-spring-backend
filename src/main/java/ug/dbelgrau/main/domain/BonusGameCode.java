package ug.dbelgrau.main.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BonusGameCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Code cannot be blank")
//    @Size(min = 9, max = 9,message = "Code must be 9 characters")
    private String code;

    @OneToOne
    @JoinColumn(name = "gpu_id")
    @JsonBackReference
    private Gpu gpu;
}
