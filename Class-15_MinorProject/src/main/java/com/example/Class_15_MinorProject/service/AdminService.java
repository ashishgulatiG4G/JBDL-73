package com.example.Class_15_MinorProject.service;

import com.example.Class_15_MinorProject.models.Admin;
import com.example.Class_15_MinorProject.repository.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;

    public void createAdmin(Admin admin) {
        adminDao.save(admin);
    }



}
