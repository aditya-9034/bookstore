package aditya.netent.assignment.bookstore.repositories;

import aditya.netent.assignment.bookstore.models.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, UUID> {
}
