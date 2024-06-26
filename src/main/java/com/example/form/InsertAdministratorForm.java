package com.example.form;

/**
 * 管理者情報登録時に使⽤するformクラス
 * @author umemura
 */
public class InsertAdministratorForm {

    private String name;
    private String mailAddress;
    private String password;

    public String getName() {
        return name;
    }
    public String getMailAddress() {
        return mailAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
                + "]";
    }
}
