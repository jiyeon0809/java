package com.example.tobi.team3.mapper;

import com.example.tobi.team3.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void signUp(User user);
    User signIn(String userId);
    User findId(User user);
}
