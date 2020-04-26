package aditya.netent.assignment.bookstore.controllers;

import io.searchbox.client.JestClient;
import io.searchbox.indices.CreateIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class IndexController {

    @Autowired
    JestClient jestClient;

    @GetMapping("/")
    public String index(){
        try {
            jestClient.execute(new CreateIndex.Builder("orders").build());
        } catch(IOException io){

        }
        return "index";
    }
}
