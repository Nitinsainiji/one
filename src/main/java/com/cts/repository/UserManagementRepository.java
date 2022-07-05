package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.UserManagement;

public interface UserManagementRepository  extends JpaRepository<UserManagement,Integer>{

}
