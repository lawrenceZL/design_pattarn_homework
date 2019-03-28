package cn.edu.nju.software.design_pattern_homework_server.dao;

import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterWeapon;
import org.springframework.data.repository.CrudRepository;

public interface UserCharacterWeaponRepository extends CrudRepository<UserCharacterWeapon, Long> {
    UserCharacterWeapon findByUserCharacterId(Long userCharacterId);
}
