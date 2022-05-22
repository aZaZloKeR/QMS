package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.Users;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;
import java.util.Optional;

@PersistenceContext(unitName = "QMS")
public interface UsersRepo extends CrudRepository<Users,Integer> {
    Optional<Users> findByLogin(String login);
}
