package com.reservations.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ContactDetails {

    @Length(max = 13)
    @Pattern(regexp = "[+0-9]+", message = "cellNumber field must contains digits")
    @Schema(example = "0831231231")
    private String cellNumber;
    @Length(max = 13)
    @Pattern(regexp = "[+0-9]+", message = "workNumber field must contains digits")
    @Schema(example = "0111231231")
    private String workNumber;

    @Email
    @NotBlank
    @Schema(example = "jeff@notbezos.com")
    private String email;
}
