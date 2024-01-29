package com.github.filmesAPI.controllers;


import com.github.filmesAPI.entities.models.FilmeModel;
import com.github.filmesAPI.exceptions.CreateFilmeException;
import com.github.filmesAPI.exceptions.DeleteFilmeException;
import com.github.filmesAPI.services.CrudFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmesController {

    @Autowired
    CrudFilmeService crudFilmeService;
    @GetMapping("/get")
    public ResponseEntity<Iterable<FilmeModel>> getFilmes(){
        return new ResponseEntity<>(crudFilmeService.getFilmes(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createFilmes(@RequestBody FilmeModel data) throws CreateFilmeException {
        return new ResponseEntity<>(crudFilmeService.createFilmes(data), HttpStatus.CREATED);

    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteFilmes(@RequestParam Long id) throws DeleteFilmeException {
        return new ResponseEntity<>(crudFilmeService.deleteFilmes(id), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateFilmes(@RequestBody FilmeModel filmeModel, @RequestParam Long id){
        return new ResponseEntity<>(crudFilmeService.updateFilmes(filmeModel, id), HttpStatus.OK);
    }
}
