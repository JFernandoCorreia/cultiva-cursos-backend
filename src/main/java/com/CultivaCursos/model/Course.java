package com.CultivaCursos.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do curso não pode ser vazio")
    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Positive(message = "O número de vagas deve ser positivo")
    @Column(nullable = false)
    private int vagas;

    private String local;

    @Temporal(TemporalType.DATE)
    @FutureOrPresent(message = "A data limite de inscrição deve ser no presente ou no futuro")
    private Date dataLimiteInscricao;

    @Temporal(TemporalType.DATE)
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
