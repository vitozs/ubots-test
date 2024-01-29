package com.github.filmesAPI.controllers;


import com.github.filmesAPI.entities.DTO.ReviewDTO;
import com.github.filmesAPI.entities.models.ReviewModel;
import com.github.filmesAPI.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("create")
    public ResponseEntity<String> createReview(@RequestBody ReviewDTO review, @RequestParam Long id){
        return new ResponseEntity<>(reviewService.createReview(review, id), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateReview(@RequestBody ReviewDTO review, @RequestParam Long id){
        return new ResponseEntity<>(reviewService.updateReview(review, id), HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteReview(@RequestParam Long id){
        return new ResponseEntity<>(reviewService.deleteReview(id), HttpStatus.OK);
    }


}
