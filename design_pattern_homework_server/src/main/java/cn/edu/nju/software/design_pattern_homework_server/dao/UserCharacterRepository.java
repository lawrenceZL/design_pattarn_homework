package cn.edu.nju.software.design_pattern_homework_server.dao;

import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCharacterRepository extends CrudRepository<UserCharacter, Long> {

    List<UserCharacter> findAllByUserId(Long userId);
}
