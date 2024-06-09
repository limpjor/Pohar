package com.example.pohar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "El nombre no puede ser nulo.")
    @Size(max=40, message="El nombre no puede tener más de 40 caracteres.")
    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;

    @NotNull(message = "El apellido no puede ser nulo.")
    @Size(max=40, message="El apellido no puede tener más de 40 caracteres.")
    @Column(name = "apellido", nullable = false, length = 40)
    private String apellido;

    @Size(max=40, message="El correo electrónico no puede tener más de 40 caracteres.")
    @Pattern(regexp = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", message = "El correo electrónico no tiene un formato válido.")
    @Column(name = "email", nullable = false, unique = true, length = 40)
    private String email;

    @NotNull(message = "Los creditos no pueden ser nulo.")
    @Column(name = "creditos", nullable = false)
    private Integer creditos;

    @NotNull(message = "El semestre electrónico no puede ser nulo.")
    @Column(name = "semestre", nullable = false)
    private Integer semestre;

    @NotNull(message = "El promedio electrónico no puede ser nulo")
    @Column(name = "promedio", nullable = false)
    private Integer promedio;
}
