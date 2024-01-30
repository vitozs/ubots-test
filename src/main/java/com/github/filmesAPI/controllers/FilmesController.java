package com.github.filmesAPI.controllers;


import com.github.filmesAPI.entities.DTO.FilmeDTO;
import com.github.filmesAPI.entities.models.FilmeModel;
import com.github.filmesAPI.exceptions.CreateFilmeException;
import com.github.filmesAPI.exceptions.DeleteFilmeException;
import com.github.filmesAPI.services.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class FilmesController {
    @Autowired
    FilmesService filmesService;
    @GetMapping("get")
    public ResponseEntity<Iterable<FilmeModel>> getFilmes(){
        return new ResponseEntity<>(filmesService.getFilmes(), HttpStatus.OK);
    }

    @GetMapping("reccomendMovie")
    public ResponseEntity<List<FilmeModel>> getFilmeSemReview(){
        return new ResponseEntity<>(filmesService.getFilmeRecomendado(), HttpStatus.OK);
    }
    @PostMapping("create")
    public ResponseEntity<String> createFilmes(@RequestBody FilmeDTO data) throws CreateFilmeException {
        return new ResponseEntity<>(filmesService.createFilmes(data), HttpStatus.CREATED);

    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteFilmes(@RequestParam Long id) throws DeleteFilmeException {
        return new ResponseEntity<>(filmesService.deleteFilmes(id), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateFilmes(@RequestBody FilmeDTO filmeModel, @RequestParam Long id){
        return new ResponseEntity<>(filmesService.updateFilmes(filmeModel, id), HttpStatus.OK);
    }
}
