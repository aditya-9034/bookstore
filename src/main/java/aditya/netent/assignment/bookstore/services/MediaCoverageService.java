package aditya.netent.assignment.bookstore.services;

import aditya.netent.assignment.bookstore.models.MediaCoverage;

import java.util.List;

public interface MediaCoverageService {
    List<MediaCoverage> getMediaCoverageForBook(String title);
}
