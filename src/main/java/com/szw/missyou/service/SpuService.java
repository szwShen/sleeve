package com.szw.missyou.service;

import com.szw.missyou.model.Spu;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/5 - 08 - 05 - 13:10
 * @Description: com.szw.missyou.service
 * @version: 1.0
 */
public interface SpuService {
    Spu getSpuById(Long id);

    Page<Spu> getLatsSpu(Integer pageNum, Integer size);


    Page<Spu> getByCategroy(Long cid, Boolean is_root, Integer pageNum, Integer size);


}
