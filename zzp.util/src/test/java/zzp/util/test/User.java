package zzp.util.test;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.05.08
 **/
public class User implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录名
     */
    private String loginId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String toString() {
        return id + ", " + userName + ", " + loginId;
    }

}
