package com.example.zsgc.controller;

import com.example.zsgc.entity.Role;
import com.example.zsgc.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Policy;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleMapper roleMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @RequestMapping(value = {"/selectById"}, method = RequestMethod.GET)
    public Role selectByRoleId(int roleId) {
        return roleMapper.selectByRoleId(roleId);
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.GET)
    public List<Role> selectByName(String roleName) {
        return roleMapper.selectByName(roleName);
    }

    @RequestMapping(value = {"/selectByGender"}, method = RequestMethod.GET)
    public List<Role> selectByGender(int gender) {
        return roleMapper.selectByGender(gender);
    }

    @RequestMapping(value = {"/selectByWorkName"}, method = RequestMethod.GET)
    public List<Role> selectByWorkName(String workName) {
        return roleMapper.selectByWorkName(workName);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertRole(Role role) {
        roleMapper.insertRole(role);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteRole(int roleId) {
        roleMapper.deleteRole(roleId);
    }
}
