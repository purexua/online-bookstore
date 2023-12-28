package com.purexua.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.purexua.mapper.UserMapper;
import com.purexua.pojo.User;
import com.purexua.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
