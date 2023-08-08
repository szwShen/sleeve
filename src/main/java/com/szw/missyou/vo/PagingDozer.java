package com.szw.missyou.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/5 - 08 - 05 - 17:07
 * @Description: com.szw.missyou.vo
 * @version: 1.0
 */
public class PagingDozer<T, K> extends Paging {
    public PagingDozer(Page<T> pageT, Class<K> kClass) {
        this.initialParams(pageT);
        List<T> tList = pageT.getContent();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> kList = new ArrayList<K>();
        tList.forEach(t -> {
                    K vo = mapper.map(t, kClass);
                    kList.add(vo);
                }
        );
        this.setItems(kList);
    }
}
