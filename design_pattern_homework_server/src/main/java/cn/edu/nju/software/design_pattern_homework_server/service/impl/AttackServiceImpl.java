package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.AttackCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.GoblinCharacter;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.AttackContext;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.CharacterAttackStrategy;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.GoblinAttackStrategy;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.decorater.*;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterRepository;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterSkillRepository;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterWeaponRepository;
import cn.edu.nju.software.design_pattern_homework_server.dto.CharacterEquipmentDto;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacter;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterSkill;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterWeapon;
import cn.edu.nju.software.design_pattern_homework_server.service.AttackService;
import cn.edu.nju.software.design_pattern_homework_server.service.EquipmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@Service
public class AttackServiceImpl implements AttackService {

    @Resource
    private UserCharacterRepository userCharacterDao;
    @Resource
    private UserCharacterWeaponRepository userCharacterWeaponDao;
    @Resource
    private UserCharacterSkillRepository userCharacterSkillDao;
    @Resource
    private EquipmentService equipmentService;

    @Override
    public Result attack(AttackCommand command) {
        GoblinCharacter goblin = command.getGoblin();
        AttrInterface goblin_attrs = new CharacterAttrCommand();
        BeanUtils.copyProperties(goblin, goblin_attrs);

        Optional<UserCharacter> op_character = userCharacterDao.findById(command.getUserCharacterId());
        if (!op_character.isPresent()) {
            return Result.error().message("获取用户信息失败！");
        }
        UserCharacter userCharacter = op_character.get();
        //装饰者模式进行加成属性统计
        AttrInterface character = new CharacterAttrCommand();
        BeanUtils.copyProperties(userCharacter, character);

        //添加技能装饰
        if (null != command.getSkillId()) {
            Optional<UserCharacterSkill> op_skill = userCharacterSkillDao.findById(command.getSkillId());
            if (op_skill.isPresent()) {
                UserCharacterSkill skill = op_skill.get();
                //如果使用了技能，则装饰上
                character = new SkillDecorator(character);
                BeanUtils.copyProperties(skill, character);
            }
        }
        //添加武器装饰
        UserCharacterWeapon weapon = userCharacterWeaponDao.findByUserCharacterId(command.getUserCharacterId());
        character = new WeaponDecorator(character);
        BeanUtils.copyProperties(weapon,character);
        //添加装备装饰
        Result result = equipmentService.getEquipedEquips(command.getUserCharacterId());
        if (result.isSuccess()){
            Map<EQUIP_TYPE, CharacterEquipmentDto> map = (Map<EQUIP_TYPE, CharacterEquipmentDto>)result.getData();
            //遍历map
            for (EQUIP_TYPE type : map.keySet()){
                CharacterEquipmentDto dto = map.get(type);
                character = new EquipDecorator(character);
                BeanUtils.copyProperties(dto,character);
            }
        }
        //进行最终的进攻
        command.getUserCharacterId();
        AttackContext attackContext;
        double attack = 0.0;
        if (command.isFlag()) {
            //flag=true 人打哥布林
            attackContext = new AttackContext(new CharacterAttackStrategy());
            attack = attackContext.execute(character.obtainAttr(), goblin_attrs.obtainAttr(),command.getType());

        } else {
            //否则是哥布林打人
            attackContext = new AttackContext(new GoblinAttackStrategy());
            attack = attackContext.execute( goblin_attrs.obtainAttr(),character.obtainAttr(),command.getType());
        }
        return Result.success().message("造成伤害成功！").withData((int)attack);
    }
}
