package ma.enset.patientmvc.sec.repositories;

import ma.enset.patientmvc.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {
    AppRole findByRoleName(String roleName);
}
