package com.tmjonker.burgerbonanza.dtos;

import java.io.Serializable;

public class ChangePasswordDTO implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String oldPassword;
    private String newPassword;

    public ChangePasswordDTO() {

    }

    public ChangePasswordDTO(String username, String oldPassword, String newPassword) {
        this.username = username;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}

