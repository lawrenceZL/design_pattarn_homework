package cn.edu.nju.software.design_pattern_homework_server.dao;

import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterEquipment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCharacterEquipmentRepository extends CrudRepository<UserCharacterEquipment, Long> {
    List<UserCharacterEquipment> findAllByUserCharacterIdAndEquiped(Long userCharacterId, Boolean equiped);
}
