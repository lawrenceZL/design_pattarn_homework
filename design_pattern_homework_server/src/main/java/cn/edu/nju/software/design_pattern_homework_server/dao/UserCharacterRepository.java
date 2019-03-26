package cn.edu.nju.software.design_pattern_homework_server.dao;

import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacter;
import org.springframework.data.repository.CrudRepository;

public interface UserCharacterRepository extends CrudRepository<UserCharacter, Long> {
}
