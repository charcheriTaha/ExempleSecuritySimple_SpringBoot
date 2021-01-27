package org.sid.dao;

import org.sid.entities.Role;
import org.sid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String>{
	default Role findOne(String id) { 
        return (Role) findById(id).orElse(null); 
    } 

}
