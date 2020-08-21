package pl.pg.tmanager.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    //@Query("select u from User u where u.email =:email and u.id <>:id")
    //User findByEmailToUpdate(@Param("email") String email, @Param("id") Long id);

    User findByNick(String nick);
}
