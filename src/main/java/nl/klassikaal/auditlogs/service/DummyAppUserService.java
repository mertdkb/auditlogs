package nl.klassikaal.auditlogs.service;

import nl.klassikaal.auditlogs.model.AppUser;
import nl.klassikaal.auditlogs.model.AppUserPersonalInfo;
import nl.klassikaal.auditlogs.utils.StringUtils;

public class DummyAppUserService {
    private DummyAppUserService() {
    }

    public static AppUser createDummyUser() {
        AppUser appUser = new AppUser();
        AppUserPersonalInfo personalInfo = createDummyPersonalInfo();
        personalInfo.setUser(appUser);
        appUser.setPersonalinfo(personalInfo);
        return appUser;
    }

    public static AppUserPersonalInfo createDummyPersonalInfo() {
        AppUserPersonalInfo personalInfo = new AppUserPersonalInfo();
        personalInfo.setFirstname(StringUtils.generateRandomFirstname());
        personalInfo.setLastname(StringUtils.generateRandomLastname());
        personalInfo.setEmail(StringUtils.generateRandomEmail());
        personalInfo.setPhonenumber(StringUtils.generateRandomPhonenumber());
        return personalInfo;
    }
}
