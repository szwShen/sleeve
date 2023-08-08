package com.szw.missyou.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.szw.missyou.utils.GenericAndJson;
import com.szw.missyou.utils.ListAndJson;
import com.szw.missyou.utils.MapAndJson;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "sku", schema = "sleeve", catalog = "")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sku  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "discount_price")
    private BigDecimal discountPrice;
    @Basic
    @Column(name = "online")
    private byte online;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "spu_id")
    private int spuId;


    //
//    @Basic
//    @Column(name = "specs")
//    @Convert(converter = GenericAndJson.class)
    private String specs;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "stock")
    private int stock;
    @Basic
    @Column(name = "category_id")
    private Integer categoryId;
    @Basic
    @Column(name = "root_category_id")
    private Integer rootCategoryId;

    public List<Spec> getSpecs() {
        if (this.specs == null) {
            return Collections.emptyList();
        }
        return GenericAndJson.jsonToObject(this.specs, new TypeReference<List<Spec>>() {
        });
    }

    public void setSpecs(List<Spec> specs) {
        if (specs.isEmpty()) {
            return;
        }
        this.specs = GenericAndJson.objectToJson(specs);
    }

    @JsonIgnore
    public List<String> getSpecValueList() {
        return this.getSpecs().stream().map(Spec::getValue).collect(Collectors.toList());
    }

}
