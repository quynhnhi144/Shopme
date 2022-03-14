package com.shopme.admin.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopme.common.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	// unit test ===> logic, service

	/*
	 * dbunit test ===> db 
	 * ==> real database
	 * ==> mock data
	 */

}
