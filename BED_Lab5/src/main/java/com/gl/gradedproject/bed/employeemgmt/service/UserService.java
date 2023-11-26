package com.gl.gradedproject.bed.employeemgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.gradedproject.bed.employeemgmt.entity.User;

@Service
public interface UserService {
	User addUser(User user);

	List<User> addUsers(List<User> users);

	List<User> allUsers();

	void deleteUserById(Long id);

	void deleteUserByIds(List<Long> ids);
}
