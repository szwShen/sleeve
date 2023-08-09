package com.szw.missyou.repository;

import com.szw.missyou.model.User;
import org.springframework.stereotype.Component;

/**
 * @Auther: szw
 * @Date: 2023/8/9 - 08 - 09 - 11:46
 * @Description: com.szw.missyou.repository
 * @version: 1.0
 */
@Component
public interface UserRepository {
    User findByEmail(String email);

    User findByOpenId(String openid);

    User findFirstById(Long id);

    User findByUnifyUid(Long uuid);

    void save(User user);
}
