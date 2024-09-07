package com.example.Class_15_MinorProject.service;

import com.example.Class_15_MinorProject.models.Admin;
import com.example.Class_15_MinorProject.models.User;
import com.example.Class_15_MinorProject.repository.AdminDao;
import com.example.Class_15_MinorProject.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;

    @Autowired
    UserService userService;

    public void createAdmin(Admin admin) throws Exception {

        // Create user object

        User user = admin.getUser();
        user = userService.save(Constants.ADMIN_USER, user);

        if(user.getId() == null) {
            throw new Exception("Invalid User");
            // TODO - handle exception
        }

        admin.setUser(user);

        // Save it
        //add it to admin

        adminDao.save(admin);
    }

    public Admin findAdmin(Integer adminId) {
        return adminDao.findById(adminId).orElse(null);
    }



}
