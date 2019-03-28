package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SKILL_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.dao.CharacterRepository;
import cn.edu.nju.software.design_pattern_homework_server.dao.EquipmentRepository;
import cn.edu.nju.software.design_pattern_homework_server.dao.SkillRepository;
import cn.edu.nju.software.design_pattern_homework_server.dao.WeaponRepository;
import cn.edu.nju.software.design_pattern_homework_server.entity.Character;
import cn.edu.nju.software.design_pattern_homework_server.entity.*;
import cn.edu.nju.software.design_pattern_homework_server.service.InitService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {

    @Resource
    private CharacterRepository characterDao;
    @Resource
    private WeaponRepository weaponDao;
    @Resource
    private SkillRepository skillDao;
    @Resource
    private EquipmentRepository equipmentDao;

    @Override
    public void initAll() {
        this.initCharacter();
        this.initWeapon();
        this.initSkill();
        this.initEquipment();
    }

    @Override
    public void initWeapon() {
        //物理攻击,魔法攻击,物理防御,魔法防御,暴击率,暴击伤害,敏捷度
        Weapon weapon1 = weaponInstance(1L, "龙鳞刀", 2.0, 30.0);
        initAttr(weapon1, 50., 0., 50., 0., 0., 5., 0.);

        Weapon weapon2 = weaponInstance(2L, "御灵法杖", 2.0, 30.0);
        initAttr(weapon2, 0., 50., 0., 50., 0., 5., 0.);

        Weapon weapon3 = weaponInstance(3L, "亡灵匕首", 2.0, 30.0);
        initAttr(weapon3, 40., 0., 40., 20., 0., 0., 5.);
        weaponDao.save(weapon1);
        weaponDao.save(weapon2);
        weaponDao.save(weapon3);
    }

    private Weapon weaponInstance(Long characterId, String name, Double percentLimit, Double valueLimit) {
        Weapon weapon = new Weapon();
        weapon.setName(name);
        weapon.setUpgradePercentLimit(percentLimit);
        weapon.setUpgradeValueLimit(valueLimit);
        weapon.setCharacterId(characterId);
        return weapon;
    }

    @Override
    public void initSkill() {
        List<Skill> skills = Lists.newArrayList();
        //物理攻击,魔法攻击,物理防御,魔法防御,暴击率,暴击伤害,敏捷度
        Skill skill1_1 = skillInstance(1L, "刀斩天下");
        initAttr(skill1_1, 20., 0., 10., 20., 0., 5., 0.);
        skills.add(skill1_1);

        Skill skill1_2 = skillInstance(1L, "气破山河");
        initAttr(skill1_2, 20., 0., 10., 20., 0., 5., 0.);
        skills.add(skill1_2);

        Skill skill1_3 = skillInstance(1L, "八荒极刃");
        initAttr(skill1_3, 20., 0., 10., 20., 0., 5., 0.);
        skills.add(skill1_3);

        Skill skill1_4 = skillInstance(1L, "腾龙在天");
        initAttr(skill1_4, 20., 0., 10., 20., 0., 5., 0.);
        skills.add(skill1_4);

        //物理攻击,魔法攻击,物理防御,魔法防御,暴击率,暴击伤害,敏捷度
        Skill skill2_1 = skillInstance(2L, "万里冰封");
        initAttr(skill2_1, 0., 20., 10., 20., 0., 5., 0.);
        skills.add(skill2_1);

        Skill skill2_2 = skillInstance(2L, "天火焚野");
        initAttr(skill2_2, 0., 20., 10., 20., 0., 5., 0.);
        skills.add(skill2_2);

        Skill skill2_3 = skillInstance(2L, "雷赦九天");
        initAttr(skill2_3, 0., 20., 10., 20., 0., 5., 0.);
        skills.add(skill2_3);

        Skill skill2_4 = skillInstance(2L, "光影寂灭");
        initAttr(skill2_4, 0., 20., 10., 20., 0., 5., 0.);
        skills.add(skill2_4);

        //物理攻击,魔法攻击,物理防御,魔法防御,暴击率,暴击伤害,敏捷度
        Skill skill3_1 = skillInstance(3L, "鬼影迷踪");
        initAttr(skill3_1, 15., 10., 15., 10., 0., 0., 3.);
        skills.add(skill3_1);

        Skill skill3_2 = skillInstance(3L, "双刃穿透");
        initAttr(skill3_2, 15., 10., 15., 10., 0., 0., 3.);
        skills.add(skill3_2);

        Skill skill3_3 = skillInstance(3L, "凶神鬼刺");
        initAttr(skill3_3, 15., 10., 15., 10., 0., 0., 3.);
        skills.add(skill3_3);

        Skill skill3_4 = skillInstance(3L, "绝命瞬杀");
        initAttr(skill3_4, 15., 10., 15., 10., 0., 0., 3.);
        skills.add(skill3_4);

        skillDao.saveAll(skills);
    }

    private Skill skillInstance(Long characterId, String name) {
        Skill skill = new Skill();
        skill.setCharacterId(characterId);
        skill.setName(name);
        skill.setSkillLevel(SKILL_LEVEL.NOT_LEARN);
        return skill;
    }

    @Override
    public void initCharacter() {
        Character hero1 = new Character();
        hero1.setName("刀客");
        hero1.setEnName("Swordsman");
        hero1.setEXP(100.0);
        hero1.setMAG(100.0);
        hero1.setHP(200.0);
        hero1.setLevel(1);
        //物理攻击
        //魔法攻击
        //物理防御
        //魔法防御
        //暴击率
        //暴击伤害
        //敏捷度
        initAttr(hero1, 100., 80., 50., 40., 10., 50., 18.);
        Character hero2 = new Character();
        hero2.setName("法师");
        hero2.setEnName("Wizard");
        hero2.setEXP(100.0);
        hero2.setMAG(200.0);
        hero2.setHP(100.0);
        hero2.setLevel(1);
        initAttr(hero2, 80.0, 100., 40., 50., 10., 50., 15.);
        Character hero3 = new Character();
        hero3.setName("盗贼");
        hero3.setEnName("Thief");
        hero3.setEXP(100.0);
        hero3.setMAG(150.0);
        hero3.setHP(150.0);
        hero3.setLevel(1);
        initAttr(hero3, 90., 90., 45., 45., 8., 50., 20.);
        characterDao.save(hero1);
        characterDao.save(hero2);
        characterDao.save(hero3);

    }

    @Override
    public void initEquipment() {
        List<Equipment> equipments = Lists.newArrayList();
        String[] character_names = {"刀客", "法师", "盗贼"};
        EQUIP_TYPE[] equip_types = {EQUIP_TYPE.HEAD, EQUIP_TYPE.MASK, EQUIP_TYPE.HAND, EQUIP_TYPE.BODY, EQUIP_TYPE.LEG, EQUIP_TYPE.FOOT};
        String[] equip_type_strs = {"头甲", "面具", "手套", "身甲", "长裤", "鞋子"};
        EQUIP_LEVEL[] equip_levels = {EQUIP_LEVEL.SP, EQUIP_LEVEL.SSR, EQUIP_LEVEL.SR, EQUIP_LEVEL.R, EQUIP_LEVEL.N};
        String[] equip_level_strs = {"SP", "SSR", "SR", "R", "N"};
        Double[] percentLimits = {0.5, 1.0, 1.5, 2.0, 2.5};
        Double[] valueLimits = {5.0, 15.0, 25.0, 35.0, 45.0};
        Double[][][][] attrs = {
                //物理攻击,魔法攻击,物理防御,魔法防御,暴击率,暴击伤害,敏捷度
                //刀客
                {//装备类型
                        {{5., 0., 3., 0., 3., 0., 0.}, {50., 0., 30., 0., 5., 0., 0.}, {500., 0., 300., 10., 0., 0., 0.}, {1500., 0., 900., 0., 20., 0., 0.}, {5000., 0., 3000., 0., 30., 0., 0.}},
                        {{5., 0., 3., 0., 3., 0., 0.}, {50., 0., 30., 0., 5., 0., 0.}, {500., 0., 300., 10., 0., 0., 0.}, {1500., 0., 900., 0., 20., 0., 0.}, {5000., 0., 3000., 0., 30., 0., 0.}},
                        {{5., 0., 3., 0., 3., 0., 0.}, {50., 0., 30., 0., 5., 0., 0.}, {500., 0., 300., 10., 0., 0., 0.}, {1500., 0., 900., 0., 20., 0., 0.}, {5000., 0., 3000., 0., 30., 0., 0.}},
                        {{5., 0., 3., 0., 3., 0., 0.}, {50., 0., 30., 0., 5., 0., 0.}, {500., 0., 300., 10., 0., 0., 0.}, {1500., 0., 900., 0., 20., 0., 0.}, {5000., 0., 3000., 0., 30., 0., 0.}},
                        {{5., 0., 3., 0., 3., 0., 0.}, {50., 0., 30., 0., 5., 0., 0.}, {500., 0., 300., 10., 0., 0., 0.}, {1500., 0., 900., 0., 20., 0., 0.}, {5000., 0., 3000., 0., 30., 0., 0.}},
                        {{5., 0., 3., 0., 3., 0., 0.}, {50., 0., 30., 0., 5., 0., 0.}, {500., 0., 300., 10., 0., 0., 0.}, {1500., 0., 900., 0., 20., 0., 0.}, {5000., 0., 3000., 0., 30., 0., 0.}}
                },
                //法师
                {//装备类型
                        {{0., 5., 0., 3., 3., 0., 0.}, {0., 50., 0., 30., 5., 0., 0.}, {0., 500., 0., 300., 10., 0., 0.}, {0., 1500., 0., 900., 20., 0., 0.}, {0., 5000., 0., 3000., 30., 0., 0.}},
                        {{0., 5., 0., 3., 3., 0., 0.}, {0., 50., 0., 30., 5., 0., 0.}, {0., 500., 0., 300., 10., 0., 0.}, {0., 1500., 0., 900., 20., 0., 0.}, {0., 5000., 0., 3000., 30., 0., 0.}},
                        {{0., 5., 0., 3., 3., 0., 0.}, {0., 50., 0., 30., 5., 0., 0.}, {0., 500., 0., 300., 10., 0., 0.}, {0., 1500., 0., 900., 20., 0., 0.}, {0., 5000., 0., 3000., 30., 0., 0.}},
                        {{0., 5., 0., 3., 3., 0., 0.}, {0., 50., 0., 30., 5., 0., 0.}, {0., 500., 0., 300., 10., 0., 0.}, {0., 1500., 0., 900., 20., 0., 0.}, {0., 5000., 0., 3000., 30., 0., 0.}},
                        {{0., 5., 0., 3., 3., 0., 0.}, {0., 50., 0., 30., 5., 0., 0.}, {0., 500., 0., 300., 10., 0., 0.}, {0., 1500., 0., 900., 20., 0., 0.}, {0., 5000., 0., 3000., 30., 0., 0.}},
                        {{0., 5., 0., 3., 3., 0., 0.}, {0., 50., 0., 30., 5., 0., 0.}, {0., 500., 0., 300., 10., 0., 0.}, {0., 1500., 0., 900., 20., 0., 0.}, {0., 5000., 0., 3000., 30., 0., 0.}},
                },
                //盗贼
                {//装备类型
                        {{2.5, 2.5, 1.5, 1.5, 3., 0., 0.}, {25., 25., 15., 15., 5., 0., 0.}, {250., 250., 150., 150., 10., 0., 0.}, {1200., 1200., 700., 700., 20., 0., 0.}, {4000., 4000., 2000., 2000., 30., 0., 0.}},
                        {{2.5, 2.5, 1.5, 1.5, 3., 0., 0.}, {25., 25., 15., 15., 5., 0., 0.}, {250., 250., 150., 150., 10., 0., 0.}, {1200., 1200., 700., 700., 20., 0., 0.}, {4000., 4000., 2000., 2000., 30., 0., 0.}},
                        {{2.5, 2.5, 1.5, 1.5, 3., 0., 0.}, {25., 25., 15., 15., 5., 0., 0.}, {250., 250., 150., 150., 10., 0., 0.}, {1200., 1200., 700., 700., 20., 0., 0.}, {4000., 4000., 2000., 2000., 30., 0., 0.}},
                        {{2.5, 2.5, 1.5, 1.5, 3., 0., 0.}, {25., 25., 15., 15., 5., 0., 0.}, {250., 250., 150., 150., 10., 0., 0.}, {1200., 1200., 700., 700., 20., 0., 0.}, {4000., 4000., 2000., 2000., 30., 0., 0.}},
                        {{2.5, 2.5, 1.5, 1.5, 3., 0., 0.}, {25., 25., 15., 15., 5., 0., 0.}, {250., 250., 150., 150., 10., 0., 0.}, {1200., 1200., 700., 700., 20., 0., 0.}, {4000., 4000., 2000., 2000., 30., 0., 0.}},
                        {{2.5, 2.5, 1.5, 1.5, 3., 0., 0.}, {25., 25., 15., 15., 5., 0., 0.}, {250., 250., 150., 150., 10., 0., 0.}, {1200., 1200., 700., 700., 20., 0., 0.}, {4000., 4000., 2000., 2000., 30., 0., 0.}},
                },
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < equip_types.length; j++) {
                for (int k = 0; k < equip_levels.length; k++) {
                    Equipment equipment = equipmentInstance(i * 1L, equip_level_strs[k] + "_" + character_names[i] + "_" + equip_type_strs[j], equip_types[j], equip_levels[k], percentLimits[k], valueLimits[k]);
                    initAttr(equipment, attrs[i][j][k]);
                    equipments.add(equipment);
                }
            }
        }
        equipmentDao.saveAll(equipments);
    }

    private Equipment equipmentInstance(Long characterId, String name, EQUIP_TYPE type, EQUIP_LEVEL level, Double percentLimit, Double valueLimit) {
        Equipment equipment = new Equipment();
        equipment.setName(name);
        equipment.setType(type);
        equipment.setUpgradePercentLimit(percentLimit);
        equipment.setUpgradeValueLimit(valueLimit);
        equipment.setCharacterId(characterId);
        equipment.setLevel(level);
        return equipment;
    }

    //物理攻击,魔法攻击,物理防御,魔法防御,暴击率,暴击伤害,敏捷度
    private void initAttr(AttrBaseEntity entity, Double ATN, Double INT, Double DEF, Double RES, Double CRIT, Double CRIT_S, Double SPD) {
        entity.setATN(ATN);
        entity.setINT(INT);
        entity.setDEF(DEF);
        entity.setRES(RES);
        entity.setCRIT(CRIT);
        entity.setCRIT_S(CRIT_S);
        entity.setSPD(SPD);
    }

    private void initAttr(AttrBaseEntity entity, Double[] attrs) {
        if (attrs.length < 7) {
            return;
        }
        entity.setATN(attrs[0]);
        entity.setINT(attrs[1]);
        entity.setDEF(attrs[2]);
        entity.setRES(attrs[3]);
        entity.setCRIT(attrs[4]);
        entity.setCRIT_S(attrs[5]);
        entity.setSPD(attrs[6]);
    }


}
