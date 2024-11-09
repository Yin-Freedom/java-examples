package com.example.search.controller;

import com.example.common.api.CommonResult;
import com.example.search.dto.EmailDTO;
import com.example.search.service.EmailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author freedom
 */
@Api
@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public CommonResult<ResponseEntity<String>> sendEmail(@RequestBody EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO.getRecipient(), emailDTO.getSubject(), emailDTO.getContent());
        return CommonResult.success(ResponseEntity.ok("Email sent asynchronously."));
    }
}
