package com.szw.missyou.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "banner", schema = "sleeve", catalog = "")
public class Banner extends  BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "title")
    private Date title;
    @Basic
    @Column(name = "img")
    private String img;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "banner_id")
    private List<BannerItem> list;
}
