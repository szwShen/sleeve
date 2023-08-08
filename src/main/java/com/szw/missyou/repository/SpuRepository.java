package com.szw.missyou.repository;

import com.szw.missyou.model.Banner;
import com.szw.missyou.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/5 - 08 - 05 - 13:12
 * @Description: com.szw.missyou.repository
 * @version: 1.0
 */
public interface SpuRepository extends JpaRepository<Spu, Long> {
    Spu findSpuById(Long id);

    List<Spu> findAll();

    Page<Spu> findByCategoryIdOrderByCategoryIdDesc(Long cid, Pageable pageable);

    Page<Spu> findByRootCategoryIdOrderByCategoryIdDesc(Long cid, Pageable pageable);
}
