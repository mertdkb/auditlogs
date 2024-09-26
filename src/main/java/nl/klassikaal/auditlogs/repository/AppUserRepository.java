package nl.klassikaal.auditlogs.repository;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;

import nl.klassikaal.auditlogs.model.AppUser;

@JaversSpringDataAuditable
public interface AppUserRepository extends JpaRepository<AppUser, Long> {}
