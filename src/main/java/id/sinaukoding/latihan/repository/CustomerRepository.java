package id.sinaukoding.latihan.repository;

import id.sinaukoding.latihan.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByIsDeleted(boolean isDelete);
}