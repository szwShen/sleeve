package com.szw.missyou.api.v1;

import com.szw.missyou.dto.TokenGetDto;
import com.szw.missyou.exception.NotFoundException;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: szw
 * @Date: 2023/8/9 - 08 - 09 - 10:32
 * @Description: com.szw.missyou.api.v1
 * @version: 1.0
 */
@RestController
public class TokenController {
    @PostMapping("/token")
    public Map<String, String> getToken(@RequestBody @Validated TokenGetDto tokenGetDto) {
        Map<String, String> objectObjectHashMap = new HashMap<>();

        switch (tokenGetDto.getLoginType()){
            case USER_WX:
                break;
            case  USER_EMAIL:
                break;
            default:
                 throw  new NotFoundException(10003);
        }

        return null;
    }
}
