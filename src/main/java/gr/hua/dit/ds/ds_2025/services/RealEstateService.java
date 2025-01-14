package gr.hua.dit.ds.ds_2025.services;

import gr.hua.dit.ds.ds_2025.entities.RealEstate;
import gr.hua.dit.ds.ds_2025.repositories.RealEstateRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateService {

    private RealEstateRepository realEstateRepository;

    public RealEstateService(RealEstateRepository realEstateRepository) {
        this.realEstateRepository = realEstateRepository;
    }

    @Transactional
    public List<RealEstate> getRealEstates() {
        return realEstateRepository.findAll();
    }

    @Transactional
    public void saveRealEstate(RealEstate realEstate) {
        realEstateRepository.save(realEstate);
    }

    @Transactional
    public RealEstate getRealEstate(Integer realEstateId) {
        return realEstateRepository.findById(realEstateId).get();
    }

    @Transactional
    public void deleteRealEstate(RealEstate realEstate) {
        realEstateRepository.delete(realEstate);
    }

    @Transactional
    public void updateRealEstate(RealEstate realEstate) {
        realEstateRepository.save(realEstate);
    }
}