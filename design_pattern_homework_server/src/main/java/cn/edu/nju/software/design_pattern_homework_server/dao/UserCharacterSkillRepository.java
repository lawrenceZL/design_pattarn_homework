package cn.edu.nju.software.design_pattern_homework_server.dao;

import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterSkill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCharacterSkillRepository extends CrudRepository<UserCharacterSkill, Long> {

    List<UserCharacterSkill> findAllByUserCharacterId(Long userCharacterId);

}
