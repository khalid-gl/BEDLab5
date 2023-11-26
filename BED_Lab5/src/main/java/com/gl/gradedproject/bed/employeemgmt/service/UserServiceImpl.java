package com.gl.gradedproject.bed.employeemgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.gradedproject.bed.employeemgmt.entity.User;
import com.gl.gradedproject.bed.employeemgmt.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> addUsers(List<User> users) {
		return userRepository.saveAll(users);
	}

	@Override
	public List<User> allUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void deleteUserByIds(List<Long> ids) {
		userRepository.deleteAllById(ids);
	}

}
