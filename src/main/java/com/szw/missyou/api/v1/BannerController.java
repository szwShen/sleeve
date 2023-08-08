package com.szw.missyou.api.v1;

/**
 * @Auther: szw
 * @Date: 2023/8/3 - 08 - 03 - 13:07
 * @Description: com.szw.missyou2.api.v1
 * @version: 1.0
 */

import com.szw.missyou.dto.Person;
import com.szw.missyou.exception.NotFoundException;
import com.szw.missyou.model.Banner;
import com.szw.missyou.repository.BannerRepository;
import com.szw.missyou.service.BannerService;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;

@RestController
@Validated
public class BannerController {
    @Autowired
    private BannerService bannerService;

    //    @PostMapping("/test")
//    public Person test(@RequestBody @Valid Person person) {
//
//        return person;
//    };
//
//    @GetMapping("/mytest/{id}")
//    public String test2(@PathVariable("id") @Range(min = 2,max = 22,message = "szw") Integer id) {
//
//        return "hello";
//    }
//    @PostMapping("/mytest/{id}")
//    public String test3(@PathVariable("id") @Range(min = 2,max = 22,message = "szw") Integer id,
//                        @RequestParam("name") @Length(min = 2,max = 22,message = "szw2") String name) {
//
//        return "hello";
//    }

    @GetMapping("/getbanner")
    public Banner getBannerByName() {
        String name = "b1";
        return bannerService.getByName(name);

    }

    @GetMapping("/getbannerById/{id}")
    public Banner getBannerById(@PathVariable("id") Long id) {

        return bannerService.getById(id);
//        return bannerService.getByName(name);

    };





}
