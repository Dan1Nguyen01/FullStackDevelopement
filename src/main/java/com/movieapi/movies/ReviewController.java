package com.movieapi.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*") // Enable CORS for all origins
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        // Handle a POST request to create a review
        // The request body is expected to contain a JSON object with "reviewBody" and "imdbId" properties
        // Example payload: { "reviewBody": "This movie is great!", "imdbId": "tt1234567" }

        // Call the review service to create the review based on the payload
        Review createdReview = service.createReview(payload.get("reviewBody"), payload.get("imdbId"));

        // Return the created review in the response body with HTTP status OK (200)
        return new ResponseEntity<Review>(createdReview, HttpStatus.OK);
    }
}
