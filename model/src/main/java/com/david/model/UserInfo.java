package com.david.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "user_info")
public class UserInfo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nick_name")
    private String nickName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo)) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) &&
                Objects.equals(nickName, userInfo.nickName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nickName);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserInfo{");
        sb.append("id=").append(id);
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}