package com.xin.cloud.service.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xin.cloud.service.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
