package com.Main.Request;

import com.Main.Security.AppUser;

public class SaveUserRequest {
    public SaveUserRequest(AppUser value, boolean isNewPassword, String newPassword, String oldPassword) {
        this.Value = value;
        this.IsNewPassword = isNewPassword;
        this.NewPassword = newPassword;
        this.OldPassword = oldPassword;
    }

    public boolean isValid(){
        if(this.getValue() != null)
            return true;
        return false;
    }

    private AppUser Value;
    private boolean IsNewPassword;
    private String NewPassword;
    private String OldPassword;

    public AppUser getValue(){return  this.Value;}

    public void setValue(AppUser value) {
        Value = value;
    }

    public boolean getIsNewPassword(){return this.IsNewPassword;}
    public String getNewPassword(){return this.NewPassword;}
    public String getOldPassword(){return this.OldPassword;}


    public void setIsNewPassword(boolean isNewPassword) {
        IsNewPassword = isNewPassword;
    }
    public void setNewPassword(String newPassword) {
        NewPassword = newPassword;
    }
    public void setOldPassword(String oldPassword) {
        OldPassword = oldPassword;
    }



    public SaveUserRequest(){}
}
