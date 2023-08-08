package com.szw.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Auther: szw
 * @Date: 2023/8/5 - 08 - 05 - 14:33
 * @Description: com.szw.missyou.model
 * @version: 1.0
 */
@Entity
@Getter
@Setter
@Table(name = "spu_detail_img", schema = "sleeve", catalog = "")
public class SpuDetailImg extends  BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "spu_id")
    private Integer spuId;
    @Basic
    @Column(name = "index")
    private int index;

    }
