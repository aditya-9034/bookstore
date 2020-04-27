package aditya.netent.assignment.bookstore.services.impl;

import aditya.netent.assignment.bookstore.models.MediaCoverage;
import aditya.netent.assignment.bookstore.repositories.MediaCoverageRepository;
import aditya.netent.assignment.bookstore.services.MediaCoverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediaCoverageServiceImpl implements MediaCoverageService {
    @Autowired
    MediaCoverageRepository mediaCoverageRepository;

    @Override
    public List<MediaCoverage> getMediaCoverageForBook(String title){
        List<MediaCoverage> mediaCoverageList = mediaCoverageRepository.getMediaCoverage();
        List<MediaCoverage> mediaCoverageForBook = new ArrayList<>();

        title = title.toLowerCase();
        for(MediaCoverage mediaCoverage: mediaCoverageList){
            String postTitle = mediaCoverage.getTitle().toLowerCase();
            String postBody = mediaCoverage.getBody().toLowerCase();
            if(postTitle.contains(title) || postBody.contains(title)){
                mediaCoverageForBook.add(mediaCoverage);
            }
        }

        return  mediaCoverageForBook;
    }
}
