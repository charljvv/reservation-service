package com.reservations.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@Validated
public class PersonalDetails {

    @NotBlank(message = "firstName is mandatory")
    @Pattern(regexp = "[a-zA-Z]+", message = "No special characters are allowed in field firstName")
    @Schema(example = "Jeff")
    private String firstName;

    @NotBlank(message = "surname is mandatory")
    @Pattern(regexp = "[a-zA-Z]+", message = "No special characters are allowed in field surname")
    @Schema(example = "NotBezos")
    private String surname;


}
