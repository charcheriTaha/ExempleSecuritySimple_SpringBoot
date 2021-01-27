package org.sid.dao;

import org.sid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>{
	default User findOne(String id) { 
        return (User) findById(id).orElse(null); 
    } 
}
