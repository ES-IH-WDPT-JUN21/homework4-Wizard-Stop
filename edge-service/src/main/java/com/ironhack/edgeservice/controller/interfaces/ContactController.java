package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.dto.ContactDTO;
import com.ironhack.edgeservice.model.Contact;

public interface ContactController {

    Contact findById(Long id) ;
}
