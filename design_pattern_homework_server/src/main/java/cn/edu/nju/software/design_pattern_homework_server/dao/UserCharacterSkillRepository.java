package cn.edu.nju.software.design_pattern_homework_server.dao;

import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterSkill;
import org.springframework.data.repository.CrudRepository;

public interface UserCharacterSkillRepository extends CrudRepository<UserCharacterSkill, Long> {
}
