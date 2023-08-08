package com.szw.missyou.vo;

import com.szw.missyou.model.Sku;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class SpuSimplifyVO {
    private Long id;
    private String title;
    private String subtitle;
    private String price;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private String forThemeImg;
    private Long sketchSpecId;

}
