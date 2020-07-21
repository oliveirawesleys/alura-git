package com.construindo.api.apiconsulta.repository;

import com.construindo.api.apiconsulta.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
