package com.example.form;

/**
 * ログイン時に使⽤するformクラス
 * @author umemura
 */
public class LoginForm {
    
    private String mailAddress;
    private String password;

    public String getMailAddress() {
        return mailAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "LoginForm [mailAddress=" + mailAddress + ", password=" + password + "]";
    }
}
