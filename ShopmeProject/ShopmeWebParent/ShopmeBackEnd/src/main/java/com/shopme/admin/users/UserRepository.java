package com.shopme.admin.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
