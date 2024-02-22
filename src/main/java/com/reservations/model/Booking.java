package com.reservations.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(example = "1")
    private Long id;
    @Schema(example = "2024-02-22")
    private LocalDate startDate;
    @Schema(example = "2024-02-23")
    private LocalDate endDate;

    /* This can be modeled in multiple ways
    eg. A person object linked to another Entity with @OneToMany or similar approach
    But for brevity the idea is demonstrated here in a single entity
     */
    @Embedded
    @Valid
    private PersonalDetails personalDetails;

    @Embedded
    @Valid
    private ContactDetails contactDetails;

}
