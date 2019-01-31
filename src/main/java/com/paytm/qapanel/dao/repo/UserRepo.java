package com.paytm.qapanel.dao.repo;

import com.paytm.qapanel.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by anjukumari on 04/12/18
 */

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    User findByName(String name);

}
