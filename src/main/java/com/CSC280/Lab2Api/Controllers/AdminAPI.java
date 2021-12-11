package com.CSC280.Lab2Api.Controllers;


import com.CSC280.Lab2Api.Controllers.Repos.UserRepository;
import com.CSC280.Lab2Api.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin/Api")
public class AdminAPI {

    @Autowired
    private UserRepository repo;
    //@Autowired
    private UserDetailsManager udm;
    //@Autowired
    private PasswordEncoder pswdEnc = null;


    public AdminAPI(
            UserDetailsManager ud,
            PasswordEncoder enc){
        System.out.println("In myAdminController::L4myAdminController()");
        this.udm = ud;
        this.pswdEnc = enc;
    }

    @RequestMapping(path="/testCon", method= RequestMethod.GET)
    public String speak() {
        return "Connected";
    }


    @GetMapping(path = "/getUsers")
    public List<Users> findAll(){
        return repo.findAll();
    }

    @PostMapping(path = "/userAdd")
    @ResponseStatus(code= HttpStatus.CREATED)
    public String createUser(@RequestBody Users testUser) {
        if (repo.getFirstByUserName(testUser.getUserName()).isPresent()){
            throw new KeyAlreadyExistsException("That user already exists!");
        }
        repo.save(testUser);
        UserDetails newUser = User.withUsername(testUser.getUserName())
                .password(pswdEnc.encode(testUser.getPassWord()))
                .roles(testUser.getRolesList()).build();
        udm.createUser(newUser);
        return testUser.getUserName() + " saved!";
    }


}
