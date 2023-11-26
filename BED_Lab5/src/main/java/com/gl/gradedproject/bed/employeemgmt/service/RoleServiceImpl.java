package com.gl.gradedproject.bed.employeemgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.gradedproject.bed.employeemgmt.entity.Role;
import com.gl.gradedproject.bed.employeemgmt.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> addRoles(List<Role> roles) {
		roleRepository.saveAll(roles);
		return roles;
	}

	@Override
	public Role addRole(Role role) {
		roleRepository.save(role);
		return role;
	}

	@Override
	public List<Role> allRoles() {
		return roleRepository.findAll();
	}

	@Override
	public void deleteRoleById(Long id) {
		roleRepository.deleteById(id);
	}

	@Override
	public void deleteRoleByIds(List<Long> ids) {
		roleRepository.deleteAllById(ids);
	}

}
