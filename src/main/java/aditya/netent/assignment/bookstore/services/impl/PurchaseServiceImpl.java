package aditya.netent.assignment.bookstore.services.impl;

import aditya.netent.assignment.bookstore.models.Book;
import aditya.netent.assignment.bookstore.models.Purchase;
import aditya.netent.assignment.bookstore.repositories.PurchaseRepository;
import aditya.netent.assignment.bookstore.services.BookService;
import aditya.netent.assignment.bookstore.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private BookService bookService;

    @Override
    public Purchase addPurchase(Purchase purchase) {
        Purchase result = new Purchase();
        Book book = bookService.get(purchase.getBookId());

        if(book != null){
            book.setQuantity(book.getQuantity() - 1);
            bookService.update(book, book.getId());
            result = purchaseRepository.save(purchase);
        }
        return result;
    }
}
