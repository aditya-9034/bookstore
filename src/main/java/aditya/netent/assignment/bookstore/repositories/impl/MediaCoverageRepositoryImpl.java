package aditya.netent.assignment.bookstore.repositories.impl;

import aditya.netent.assignment.bookstore.models.MediaCoverage;
import aditya.netent.assignment.bookstore.repositories.MediaCoverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class MediaCoverageRepositoryImpl implements MediaCoverageRepository {

    @Autowired
    RestTemplate restTemplate;

    public List<MediaCoverage> getMediaCoverage(){
        ResponseEntity<MediaCoverage[]> response =
            restTemplate.getForEntity(
                "https://jsonplaceholder.typicode.com/posts",
                MediaCoverage[].class);
        List<MediaCoverage> mediaCoverageList = Arrays.asList(response.getBody());
        return mediaCoverageList;
    }
}
