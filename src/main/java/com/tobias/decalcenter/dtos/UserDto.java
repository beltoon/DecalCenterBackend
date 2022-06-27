package com.tobias.decalcenter.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tobias.decalcenter.models.Authority;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

public class UserDto {

    @Size(min=2, max=48, message = "username must be between 2 and 48")
    public String username;


    public String password;
    public Boolean enabled;
    public String apikey;
    @NotEmpty
    @Email(message = "invalid email address")
    public String email;
    @JsonSerialize
    public Set<Authority> authorities;

//    public Long getId() {
//        return id;
//    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public String getEmail() {
        return email;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}