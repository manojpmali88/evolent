package com.example.ContactInfo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ContactInfo.model.ContactInfo;

public interface ContactInfoRepository extends CrudRepository<ContactInfo, String>{

}
