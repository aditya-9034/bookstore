package aditya.netent.assignment.bookstore.controllers;

import aditya.netent.assignment.bookstore.models.Purchase;
import aditya.netent.assignment.bookstore.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("")
    public Purchase addPurchase(@RequestBody Purchase purchase) throws ResponseStatusException{
        Purchase response = purchaseService.addPurchase(purchase);
        if(response.getId() == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found exception");
        }
        return response;
    }
}
