package id.sinaukoding.latihan.repository;

import id.sinaukoding.latihan.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByIsDeleted(boolean isDelete);
}