package com.example.form;

/**
 * 従業員情報更新時に使⽤するformクラス
 * @author umemura
 */
public class UpdateEmployeeForm {

    private String id;
    private String dependentsCount;

    public String getId() {
        return id;
    }
    public String getDependentsCount() {
        return dependentsCount;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setDependentsCount(String dependentsCount) {
        this.dependentsCount = dependentsCount;
    }
    @Override
    public String toString() {
        return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
    }
}
