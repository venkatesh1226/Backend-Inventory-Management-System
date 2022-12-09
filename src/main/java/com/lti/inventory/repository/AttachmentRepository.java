package com.lti.inventory.repository;

import com.lti.inventory.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "*")
public interface AttachmentRepository extends JpaRepository<Attachment,String> {
}
