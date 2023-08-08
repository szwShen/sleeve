package com.szw.missyou.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Auther: szw
 * @Date: 2023/8/5 - 08 - 05 - 11:09
 * @Description: com.szw.missyou.model
 * @version: 1.0
 */
@Entity
@Table(name = "banner_item", schema = "sleeve", catalog = "")
@Data
public class BannerItem  extends  BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "keyword")
    private String keyword;
    @Basic
    @Column(name = "type")
    private short type;

    @Basic
    @Column(name = "banner_id")
    private Long bannerId;
    @Basic
    @Column(name = "name")
    private String name;


}
