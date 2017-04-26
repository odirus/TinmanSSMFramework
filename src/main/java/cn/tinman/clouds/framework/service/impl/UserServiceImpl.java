package cn.tinman.clouds.framework.service.impl;

import cn.tinman.clouds.framework.dao.UserMapper;
import cn.tinman.clouds.framework.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userDAO;

    public Integer countUser() {
        return userDAO.countUser();
    }
}
