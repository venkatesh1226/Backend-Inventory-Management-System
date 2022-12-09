package com.lti.inventory.service.attachment;

import com.ctc.wstx.util.StringUtil;
import com.lti.inventory.model.Attachment;
import com.lti.inventory.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@CrossOrigin(origins ="*")
public class AttachmentServiceImpl implements AttachmentService{

    @Autowired
    private AttachmentRepository repo;
    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName= StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try{
            if(fileName.contains("..")){
                throw new Exception("Filename contains invalid path sequence" +fileName);
            }

            Attachment attachment=new Attachment(fileName,file.getContentType(),file.getBytes());
            return repo.save(attachment);
        }
        catch(Exception e){
            throw new Exception("Cant Upload File");
        }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return repo.findById(fileId)
                .orElseThrow(()->new Exception("File not found with Id: "+fileId));
    }
}
