package gr.hua.dit.ds.ds_2025.services;

import gr.hua.dit.ds.ds_2025.entities.Owner;
import gr.hua.dit.ds.ds_2025.repositories.OwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
}