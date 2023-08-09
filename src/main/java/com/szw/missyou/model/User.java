package com.szw.missyou.model;

import com.szw.missyou.utils.MapAndJson;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Map;

/**
 * @Auther: szw
 * @Date: 2023/8/9 - 08 - 09 - 11:37
 * @Description: com.szw.missyou.model
 * @version: 1.0
 */
@Entity
@Data
@Table(name = "user", schema = "sleeve", catalog = "")
@Where(clause = "delete_time is null")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "openid")
    private String openid;
    @Basic
    @Column(name = "nickname")
    private String nickname;
    @Basic
    @Column(name = "unify_uid")
    private Long unifyUid;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "mobile")
    private String mobile;

    @Convert(converter = MapAndJson.class)
    private Map<String, Object> wxProfile;

    public User(String openid) {
        this.openid = openid;
    }

    public User() {
        
    }
}
