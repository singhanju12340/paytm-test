package com.paytm.qapanel.dao.repo;

import com.paytm.qapanel.dao.entity.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


/**
 * Created by anjukumari on 25/12/18
 */
@Repository
public interface PermissionRepo extends JpaRepository<UserPermission, Integer> {

    UserPermission findByuserId(String userId);
}
