package com.gl.gradedproject.bed.employeemgmt.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.gradedproject.bed.employeemgmt.entity.Role;
import com.gl.gradedproject.bed.employeemgmt.entity.User;
import com.gl.gradedproject.bed.employeemgmt.service.RoleService;
import com.gl.gradedproject.bed.employeemgmt.service.UserService;

@RestController
@RequestMapping("/security")
public class SecurityRestController {
	@Autowired
	RoleService roleService;
	@Autowired
	UserService userService;

	// role crud rest apis
	@GetMapping("/roles")
	public List<Role> getAllRoles() {
		List<Role> roles = roleService.allRoles();
		return roles;
	}

	@PostMapping("/addRole")
	@ResponseBody
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);

	}

	@PostMapping("/addRoles")
	@ResponseBody
	public List<Role> addRoles(@RequestBody List<Role> roles) {
		return roleService.addRoles(roles);

	}

	@DeleteMapping("/deleteRoleById")
	@ResponseBody
	public ResponseEntity<String> deleteRoleById(@RequestBody Long id) {
		roleService.deleteRoleById(id);
		return new ResponseEntity<>("Role " + id + " deleted successfully", HttpStatus.OK);
	}

	@DeleteMapping("/deleteRoleByIds")
	@ResponseBody
	public void deleteRoleByIds(@RequestBody Long[] ids) {
		roleService.deleteRoleByIds(Arrays.asList(ids));
	}

	// user crud rest apis
	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> users = userService.allUsers();
		return users;
	}

	@PostMapping("/addUser")
	@ResponseBody
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);

	}

	@PostMapping("/addUsers")
	@ResponseBody
	public List<User> addUsers(@RequestBody List<User> users) {
		return userService.addUsers(users);

	}

	@DeleteMapping("/deleteUserById")
	@ResponseBody
	public ResponseEntity<String> deleteUserById(@RequestBody Long id) {
		userService.deleteUserById(id);
		return new ResponseEntity<>("User " + id + " deleted successfully", HttpStatus.OK);
	}

	@DeleteMapping("/deleteUserByIds")
	@ResponseBody
	public void deleteUserByIds(@RequestBody Long ids) {
		userService.deleteUserByIds(Arrays.asList(ids));
	}

}
