package com.blueeye.coffee_shop.service;

import com.blueeye.coffee_shop.entity.RoleEntity;
import com.blueeye.coffee_shop.repository.RoleRepository;
import com.blueeye.coffee_shop.service.IService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity save(RoleEntity role) {
        return roleRepository.save(role);
    }
}
