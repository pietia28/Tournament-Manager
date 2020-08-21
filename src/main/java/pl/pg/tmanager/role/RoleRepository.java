package pl.pg.tmanager.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    //"SELECT DISTINCT e FROM Employee e INNER JOIN e.tasks t where t.supervisor='Denise'");
    //@Query("select r from Role r")
    @Query("select r from Role r join r.users u where u.id =:id")
    Role findRoleByUserId(@Param("id") Long id);
}
