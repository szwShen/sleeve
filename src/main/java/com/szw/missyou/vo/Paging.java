package com.szw.missyou.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/5 - 08 - 05 - 17:07
 * @Description: com.szw.missyou.vo
 * @version: 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class Paging<T> {
    public Paging(Page<T> page) {
        initialParams(page);
        this.items = page.getContent();
    }

    private Long total;
    private Integer count;
    private Integer page;
    private Integer totalPage;
    private List<T> items;

    void initialParams(Page<T> pageT) {
        this.total = pageT.getTotalElements();
        this.count = pageT.getSize();
        this.page = pageT.getNumber();
        this.totalPage = pageT.getTotalPages();
    }
}
