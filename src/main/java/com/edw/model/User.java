package com.edw.model;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * <pre>
 *     com.edw.model.User
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Apr 2023 16:08
 */
@Entity
@Table(name = "T_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String username;

    private String passwd;

    public User() {
    }

    public User(String id, String username, String passwd) {
        this.id = id;
        this.username = username;
        this.passwd = passwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
