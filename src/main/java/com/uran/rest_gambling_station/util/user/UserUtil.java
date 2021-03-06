package com.uran.rest_gambling_station.util.user;

import com.uran.rest_gambling_station.domain.Role;
import com.uran.rest_gambling_station.domain.User;
import com.uran.rest_gambling_station.dto.UserDto;
import com.uran.rest_gambling_station.util.PasswordUtil;

public class UserUtil {
    
    public static User createNewFromTo(UserDto newUser) {
        //??? Account ???
        return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getPassword(), null, Role.ROLE_USER);
    }
    
    public static UserDto asTo(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }
    
    public static User updateFromTo(User user, UserDto userDto) {
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
    
    public static User prepareToSave(User user) {
        user.setPassword(PasswordUtil.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}