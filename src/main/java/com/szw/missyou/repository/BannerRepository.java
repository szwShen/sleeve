package com.szw.missyou.repository;

import com.szw.missyou.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/4 - 08 - 04 - 12:28
 * @Description: com.szw.missyou.repository
 * @version: 1.0
 */
@Repository
public interface BannerRepository extends JpaRepository<Banner, Long>, JpaSpecificationExecutor<Banner> {
    Banner findOneById(Long id);

    @Query(value="from Banner where name = ?1")
    Banner findBannerByName(String name);

    @Query(value="select * from banner",nativeQuery=true)
    public List<Banner> findSql();

}
