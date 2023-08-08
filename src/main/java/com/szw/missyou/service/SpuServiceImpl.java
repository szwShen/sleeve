package com.szw.missyou.service;

import com.szw.missyou.model.Spu;
import com.szw.missyou.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/5 - 08 - 05 - 13:11
 * @Description: com.szw.missyou.service
 * @version: 1.0
 */
@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    private SpuRepository spuRepository;

    @Override
    public Spu getSpuById(Long id) {
        return spuRepository.findSpuById(id);
    }

    @Override
    public Page<Spu> getLatsSpu(Integer pageNum, Integer size) {
        Pageable page = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        return spuRepository.findAll(page);
    }

    @Override
    public Page<Spu> getByCategroy(Long cid, Boolean is_root, Integer pageNum, Integer size) {
        Pageable page = PageRequest.of(pageNum, size);
        if (is_root) {

            return spuRepository.findByRootCategoryIdOrderByCategoryIdDesc(cid, page);
        }else {
            return spuRepository.findByCategoryIdOrderByCategoryIdDesc(cid,page);
        }

    }
}
