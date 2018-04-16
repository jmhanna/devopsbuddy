package com.devopsbuddy.backend.persistence.repositories;

import com.devopsbuddy.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by j_mha on 3/29/2018.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
