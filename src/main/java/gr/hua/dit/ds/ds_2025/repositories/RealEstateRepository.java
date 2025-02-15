package gr.hua.dit.ds.ds_2025.repositories;

import gr.hua.dit.ds.ds_2025.entities.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Integer> {
}
