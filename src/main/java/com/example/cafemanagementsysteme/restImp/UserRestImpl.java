package com.example.cafemanagementsysteme.restImp;

import com.example.cafemanagementsysteme.constents.CafeConstants;
import com.example.cafemanagementsysteme.rest.UserRest;
import com.example.cafemanagementsysteme.service.UserService;
import com.example.cafemanagementsysteme.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {
    @Autowired
    UserService userService;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try{
           return userService.signUp(requestMap);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
