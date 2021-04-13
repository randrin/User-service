package com.randrin.fullstack.userservice.service;

import com.randrin.fullstack.userservice.entity.User;
import com.randrin.fullstack.userservice.repository.UserRepository;
import com.randrin.fullstack.userservice.request.Department;
import com.randrin.fullstack.userservice.request.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {

        ResponseTemplate responseTemplate = new ResponseTemplate();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(), Department.class);
        responseTemplate.setDepartment(department);
        responseTemplate.setUser(user);

        return responseTemplate;
    }
}
