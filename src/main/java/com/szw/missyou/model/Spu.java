package com.szw.missyou.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/5 - 08 - 05 - 13:03
 * @Description: com.szw.missyou.model
 * @version: 1.0
 */
@Entity
@Table(name = "spu", schema = "sleeve", catalog = "")
@Data
public class Spu extends  BaseEntity  {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "subtitle")
    private String subtitle;
    @Basic
    @Column(name = "category_id")
    private long categoryId;
    @Basic
    @Column(name = "root_category_id")
    private Long rootCategoryId;
    @Basic
    @Column(name = "online")
    private byte online;
    @Basic
    @Column(name = "price")
    private String price;
    @Basic
    @Column(name = "sketch_spec_id")
    private Long sketchSpecId;
    @Basic
    @Column(name = "default_sku_id")
    private Long defaultSkuId;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "discount_price")
    private String discountPrice;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "tags")
    private String tags;
    @Basic
    @Column(name = "is_test")
    private Byte isTest;
//    @Basic
//    @Column(name = "spu_theme_img")
//    private Object spuThemeImg;
    @Basic
    @Column(name = "for_theme_img")
    private String forThemeImg;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "spu_id")
    private List<SpuImg> spuImgList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "spu_id")
    private List<SpuDetailImg> spuDetailImgs;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "spu_id")
    private List<Sku> skus;

}
