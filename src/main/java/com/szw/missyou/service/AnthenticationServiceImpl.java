package com.szw.missyou.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.szw.missyou.dto.TokenGetDto;
import com.szw.missyou.exception.ParamterException;
import com.szw.missyou.model.User;
import com.szw.missyou.repository.UserRepository;
import com.szw.missyou.utils.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Optional;


/**
 * @Auther: szw
 * @Date: 2023/8/9 - 08 - 09 - 11:02
 * @Description: com.szw.missyou.service
 * @version: 1.0
 */
@Service
public class AnthenticationServiceImpl implements AnthenticationService {
    @Value("${wx.code2session}")
    private String code2session;
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.appsecret}")
    private String appsecret;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void getTokenByEmail(TokenGetDto uderData) {

    }

    @Override
    public void validateByWX(TokenGetDto userData) {

    }

    @Override
    public void register(TokenGetDto userdata) {

    }

    private String code2Session(String code) {
        String url = MessageFormat.format(this.appid, this.code2session, this.appsecret);
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(url, String.class);
        try {
            Map<String, Object> map = mapper.readValue(forObject, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private String registerUser(Map<String, Object> session) {
        String openid = (String) session.get("openid");
        if (openid == null) {
            throw new ParamterException(20004);
        }
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByOpenId(openid));
        if (userOptional.isPresent()) {
            return Jwt.makeToken(userOptional.get().getId());
        }
        User user = new User(openid);
        userRepository.save(user);
        Long id = user.getId();

        return Jwt.makeToken(id);

    }
}
