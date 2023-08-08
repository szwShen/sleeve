package com.szw.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.szw.missyou.bo.PageCounter;
import com.szw.missyou.model.Banner;
import com.szw.missyou.model.Spu;
import com.szw.missyou.service.BannerService;
import com.szw.missyou.service.SpuService;
import com.szw.missyou.utils.ComonUtils;
import com.szw.missyou.vo.Paging;
import com.szw.missyou.vo.PagingDozer;
import com.szw.missyou.vo.SpuSimplifyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/5 - 08 - 05 - 13:10
 * @Description: com.szw.missyou.api.v1
 * @version: 1.0
 */


@RestController
@Validated
public class SpuController {
    @Autowired
    private SpuService spuService;

    @GetMapping("/getSpuById/id")
    public Spu getBannerByName(@PathVariable("id") Long id) {
        String name = "b1";
        return spuService.getSpuById(id);

    }

    @GetMapping("/getListSpu")
    public void getBannerList() {
        String name = "b1";
//        return spuService.getSpuById(id);

    }

    @GetMapping("/getSpuById/{id}/simplify")
    public Spu getBannerByName2(@PathVariable("id") Long id) {
        Spu spu = spuService.getSpuById(id);
//        SpuSimplifyVO spuSimplifyVO = new SpuSimplifyVO();
//        BeanUtils.copyProperties(spuById, spuSimplifyVO);

//        return spuSimplifyVO;
        System.out.println(spu);
        return spu;
    }

    ;

    @GetMapping("/getlast")
    public PagingDozer<Spu, SpuSimplifyVO> getBannerListSimpleify(@RequestParam(defaultValue = " 0") Integer start,
                                                                  @RequestParam(defaultValue = "10") Integer count) {

        PageCounter pageCounter = ComonUtils.convertToParamter(start, count);
        Page<Spu> page = this.spuService.getLatsSpu(pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(page, SpuSimplifyVO.class);

    }

    @GetMapping("/getcateGory/{cid}")
    public PagingDozer<Spu, SpuSimplifyVO> getByCategroy(@PathVariable("cid") @Positive(message = "{id.positive}") Long id,
                                                         @RequestParam(value = "is_root",defaultValue = "false") Boolean is_root,
                                                         @RequestParam(defaultValue = " 0") Integer start,
                                                         @RequestParam(defaultValue = "10") Integer count) {

        PageCounter pageCounter = ComonUtils.convertToParamter(start, count);
        Page<Spu> page = spuService.getByCategroy(id, is_root,pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(page, SpuSimplifyVO.class);

    }
}

