package com.gl.gradedproject.bed.employeemgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.gradedproject.bed.employeemgmt.entity.Role;

@Service
public interface RoleService {
	Role addRole(Role role);

	List<Role> addRoles(List<Role> roles);

	List<Role> allRoles();

	void deleteRoleById(Long id);

	void deleteRoleByIds(List<Long> ids);

}
