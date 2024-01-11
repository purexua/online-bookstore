package com.purexua.system.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.purexua.system.mapper.UserMapper;
import com.purexua.model.system.User;
import com.purexua.system.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
