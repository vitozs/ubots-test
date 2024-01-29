package com.github.filmesAPI.entities.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "filmes")
public class FilmeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descricao;

    public void updateValues(FilmeModel data){
        if(data.getTitulo() != null){
            this.titulo = data.getTitulo();

        }
        if(data.getDescricao() != null){
            this.descricao = data.getDescricao();
        }
    }
}
