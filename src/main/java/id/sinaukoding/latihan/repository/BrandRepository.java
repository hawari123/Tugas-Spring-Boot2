package id.sinaukoding.latihan.repository;

import id.sinaukoding.latihan.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findAllByIsDeleted(boolean isDelete);
}