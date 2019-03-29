package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.level.LevelUpgradeContext;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.level.WeaponUpgradeStrategy;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterRepository;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterWeaponRepository;
import cn.edu.nju.software.design_pattern_homework_server.dto.CharacterWeaponDto;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacter;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterWeapon;
import cn.edu.nju.software.design_pattern_homework_server.service.WeaponService;
import cn.edu.nju.software.design_pattern_homework_server.util.UpdateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

@Service
public class WeaponServiceImpl implements WeaponService {

    @Resource
    private UserCharacterWeaponRepository userCharacterWeaponDao;
    @Resource
    private UserCharacterRepository userCharacterDao;

    @Override
    public Result getWeapon(Long userCharacterId) {
        UserCharacterWeapon userCharacterWeapon = userCharacterWeaponDao.findByUserCharacterId(userCharacterId);
        CharacterWeaponDto dto = new CharacterWeaponDto();
        BeanUtils.copyProperties(userCharacterWeapon, dto);
        return Result.success().withData(dto);
    }

    @Override
    public Result upgrade(UpgradeCommand command) {
        Optional<UserCharacterWeapon> op_weapon = userCharacterWeaponDao.findById(command.getId());
        if (!op_weapon.isPresent()) {
            return Result.error().message("武器信息不存在！");
        }
        UserCharacterWeapon weapon = op_weapon.get();
        return upgrade(weapon);
    }

    //需要细化锁
    private synchronized Result upgrade(UserCharacterWeapon weapon) {
        Optional<UserCharacter> op_userCharacter = userCharacterDao.findById(weapon.getUserCharacterId());
        LevelUpgradeContext levelContext = new LevelUpgradeContext(new WeaponUpgradeStrategy());
        if (!op_userCharacter.isPresent()) {
            return Result.error().message("获取用户角色信息失败！");
        }
        UserCharacter userCharacter = op_userCharacter.get();

        Values<Integer> values = levelContext.execute(weapon.getUpgradeTimes(), userCharacter.getWeaponCoupon());
        if (values.getLevel_or_upper().intValue() == weapon.getUpgradeTimes().intValue()) {
            return Result.error().message("武器券不足，无法升级该武器!");
        }
        weapon.setUpgradeTimes(values.getLevel_or_upper());
        userCharacter.setWeaponCoupon(values.getCurrent());
        userCharacter.setModifyTime(new Date());
        //更新技能属性
        UpdateUtil.upgrade(weapon, weapon.getUpgradeTimes(), true, false);
        //更新两个对象
        userCharacterDao.save(userCharacter);
        userCharacterWeaponDao.save(weapon);
        CharacterWeaponDto dto = new CharacterWeaponDto();
        BeanUtils.copyProperties(weapon, dto);
        return Result.success().message("武器升级成功！").withData(dto);
    }
}
