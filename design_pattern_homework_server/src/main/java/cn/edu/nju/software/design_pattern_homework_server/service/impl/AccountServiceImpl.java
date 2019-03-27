package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.LoginCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.RegisterCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserRepository;
import cn.edu.nju.software.design_pattern_homework_server.dto.UserDto;
import cn.edu.nju.software.design_pattern_homework_server.entity.User;
import cn.edu.nju.software.design_pattern_homework_server.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private UserRepository userDao;

    @Override
    public Result register(RegisterCommand command) {
        boolean exist = userDao.existsByUsernameIsOrMailIsOrTelIs(command.getUsername(), command.getMail(), command.getTel());
        if (exist) {
            User user = new User();
            BeanUtils.copyProperties(command, user);
            userDao.save(user);
        }
        return Result.success().message("注册成功！");
    }

    @Override
    public Result login(LoginCommand command) {
        List<User> users = userDao.findAllByUsernameIsOrMailIsOrTelIs(command.getUsername(), command.getUsername(), command.getUsername());
        for (User user : users) {
            if (user.getPassword().equals(command.getPassword())) {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(user, userDto);
                return Result.success().message("登录成功！").withData(userDto);
            }
        }
        return Result.error().message("登录失败！");
    }
}
