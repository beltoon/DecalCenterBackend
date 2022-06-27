package com.tobias.decalcenter.controllers;

import com.tobias.decalcenter.dtos.UserDto;
import com.tobias.decalcenter.exceptions.BadRequestException;
import com.tobias.decalcenter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/users/")
    public ResponseEntity<List<UserDto>> getUsers() {

        List<UserDto> userDtos = userService.getUsers();

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/users/{username}/")
    public ResponseEntity<UserDto> getUser(@PathVariable("username") String username) {

        UserDto optionalUser = userService.getUser(username);

        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping(value = "/users/")
    public ResponseEntity<Object> createAccount(@Valid @RequestBody UserDto userDto, BindingResult br) {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        else {
            String newUsername = userService.createUser(userDto);
            userService.addAuthority(newUsername, "ROLE_USER");

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/user/{username}")
                    .buildAndExpand(newUsername).toUri();

            return ResponseEntity.created(location).build();
        }
    }

    @PutMapping(value = "/users/{username}")
    public ResponseEntity<UserDto> updateAccount(@PathVariable("username") String username, @RequestBody UserDto userDto) {

        userService.updateUser(username, userDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/users/{username}")
    public ResponseEntity<Object> deleteAccount(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
        userService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }
}


