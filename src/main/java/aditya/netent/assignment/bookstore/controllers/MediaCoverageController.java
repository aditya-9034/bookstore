package aditya.netent.assignment.bookstore.controllers;

import aditya.netent.assignment.bookstore.models.MediaCoverage;
import aditya.netent.assignment.bookstore.services.MediaCoverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/media-coverage")
public class MediaCoverageController {
    @Autowired
    private MediaCoverageService mediaCoverageService;

    @GetMapping("")
    public List<MediaCoverage> getMediaCoverage(@RequestParam("title") String title){
        return mediaCoverageService.getMediaCoverageForBook(title);
    }
}
