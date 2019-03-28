package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterWeaponRepository;
import cn.edu.nju.software.design_pattern_homework_server.dto.CharacterWeaponDto;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterWeapon;
import cn.edu.nju.software.design_pattern_homework_server.service.WeaponService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WeaponServiceImpl implements WeaponService {

    @Resource
    private UserCharacterWeaponRepository userCharacterWeaponDao;

    @Override
    public Result getWeapon(Long userCharacterId) {
        UserCharacterWeapon userCharacterWeapon = userCharacterWeaponDao.findByUserCharacterId(userCharacterId);
        CharacterWeaponDto dto = new CharacterWeaponDto();
        BeanUtils.copyProperties(userCharacterWeapon, dto);
        return Result.success().withData(dto);
    }

    @Override
    public Result upgrade(UpgradeCommand command) {
        return null;
    }
}
