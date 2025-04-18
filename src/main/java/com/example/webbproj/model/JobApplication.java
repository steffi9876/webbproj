package com.example.webbproj.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String position;
    private LocalDate applicationDate;
    private String contactPerson;
    private String status; // t.ex. "Sökt", "Intervju", "Avslag"
    private String notes;
}
