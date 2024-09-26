package nl.klassikaal.auditlogs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nl.klassikaal.auditlogs.model.AppUser;
import nl.klassikaal.auditlogs.repository.AppUserRepository;

@Service
public class AppUserService {

    private AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser create(AppUser appUser) {
        
        return appUserRepository.save(appUser);
    }

    public AppUser getById(Long id) {
        return appUserRepository.findById(id).orElse(null);
    }

    public Page<AppUser> getAll(Pageable pageable) {
        return appUserRepository.findAll(pageable);
    }

    public void delete(AppUser appUser) {
        appUserRepository.delete(appUser);
    }
}
