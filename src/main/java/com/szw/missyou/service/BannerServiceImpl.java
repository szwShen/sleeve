package com.szw.missyou.service;

import com.szw.missyou.model.Banner;
import com.szw.missyou.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/4 - 08 - 04 - 9:11
 * @Description: com.szw.missyou.service
 * @version: 1.0
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public Banner getByName(String name) {
        return  bannerRepository.findBannerByName(name);


    }

    @Override
    public Banner getById(Long id) {
        return bannerRepository.findOneById(id);
    }
}
