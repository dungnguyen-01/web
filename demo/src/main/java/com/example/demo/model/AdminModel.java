package com.example.demo.model;

import com.example.demo.model.entities.Admin;
import com.example.demo.repository.AdminRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminModel {
    @Autowired
    private AdminRepsitory dao;

    public Page<Admin> getAllAdmin(Pageable pageable){
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        List<Admin> list = dao.findAllByName("dung");
        Page<Admin> bookPage
                = new PageImpl<Admin>(list, PageRequest.of(currentPage, pageSize), list.size());

        return bookPage;
    }

}
