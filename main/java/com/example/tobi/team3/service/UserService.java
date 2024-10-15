package com.example.tobi.team3.service;

import com.example.tobi.team3.mapper.UserMapper;
import com.example.tobi.team3.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public void signUp(User user) {
        userMapper.signUp(user);
    }

    public User findId(String userName, String phone){
        return userMapper.findId(
                User.builder()
                        .userName(userName)
                        .phone(phone)
                        .build());
    }

//    public User findId(String userName, String phone){
//
//        User 사용자조건 = User.builder()
//                .userName(userName)
//                .phone(phone)
//                .build();
//
//
//        User 결과물 = userMapper.findId(사용자조건);
//
//
//        return 결과물;
//    }
}
