package nl.klassikaal.auditlogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.klassikaal.auditlogs.model.AppUser;
import nl.klassikaal.auditlogs.model.AppUserPersonalInfo;
import nl.klassikaal.auditlogs.service.AppUserService;
import nl.klassikaal.auditlogs.service.DummyAppUserService;
import nl.klassikaal.auditlogs.utils.StringUtils;

@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping
    public AppUser create() {
        AppUser appUser = DummyAppUserService.createDummyUser();
        return appUserService.create(appUser);
    }

    @PutMapping("/{id}")
    public AppUser update(@PathVariable String id) {
        AppUser appUser = appUserService.getById(Long.parseLong(id));
        AppUserPersonalInfo personalInfo = appUser.getPersonalinfo();
        personalInfo.setFirstname(StringUtils.generateRandomFirstname());
        personalInfo.setLastname(StringUtils.generateRandomLastname());
        personalInfo.setEmail(StringUtils.generateRandomEmail());
        personalInfo.setPhonenumber(StringUtils.generateRandomPhonenumber());
        personalInfo.setUser(appUser);
        appUser.setPersonalinfo(personalInfo);
        return appUserService.create(appUser);
    }
}