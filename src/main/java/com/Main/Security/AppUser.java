package com.Main.Security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="OEM_OwnerEntityModel")
public class AppUser implements UserDetails {


    public AppUser(String name, String lastName, String phone, String location, boolean isShop, boolean isDeleted, boolean isAdmin, Date createdOn, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.location = location;
        this.isShop = isShop;
        this.isDeleted = isDeleted;
        this.isAdmin = isAdmin;
        this.createdOn = createdOn;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private String lastName;
    private String phone;
    private String location;
    private boolean isShop;
    private boolean isDeleted;
    private boolean isAdmin;
    private Date createdOn;
    private String email;
    @JsonIgnore
    private String password;

    public AppUser(){}


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isShop() {
        return isShop;
    }

    public void setShop(boolean shop) {
        isShop = shop;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setEmail(String uemail) {
        email = uemail;
    }
}
