package com.hospital.management.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 0, message = "Age must be non-negative")
    private int age;

    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    @NotBlank(message = "Contact number cannot be empty")
    private String contactNumber;

    @NotBlank(message = "Address cannot be empty")
    private String address;
}