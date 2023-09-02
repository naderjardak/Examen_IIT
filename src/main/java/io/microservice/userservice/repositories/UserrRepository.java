package io.microservice.userservice.repositories;

import io.microservice.userservice.entities.User;
import io.microservice.userservice.entities.enmus.RoleType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserrRepository extends CrudRepository<User,Long> {

    List<User> findUserByRoleType(RoleType roleType);

    User findUserByEmail(String email);

    User findByResetToken(String resetToken);

    @Query("select u.role.type as role ,count(u) as nb from User u group by u.role")
    List<Map<String, Integer>> statsUsersByRole();

    @Query("SELECT concat(o.UserName,'  ',count(o)) from User  o  group by o.role.type order by count (o) desc ")
    List<String> getUsersGroupedByType();
}
