package com.wesley.springhelloh2.repository;

import com.wesley.springhelloh2.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
