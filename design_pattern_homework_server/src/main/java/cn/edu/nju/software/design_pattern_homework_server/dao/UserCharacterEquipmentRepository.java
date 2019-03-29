package cn.edu.nju.software.design_pattern_homework_server.dao;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterEquipment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCharacterEquipmentRepository extends CrudRepository<UserCharacterEquipment, Long> {
    List<UserCharacterEquipment> findAllByUserCharacterIdAndEquiped(Long userCharacterId, Boolean equiped);

    @Modifying
    @Query("update #{#entityName} t set t.equiped = :equiped  where t.id = :id")
    void updateEquipedState(Long id, boolean equiped);

    @Modifying
    @Query("update #{#entityName} t set t.equiped = :equiped  where t.userCharacterId = :userCharacterId and t.type= :type")
    void updateEquipedStateByType(Long userCharacterId, EQUIP_TYPE type, boolean equiped);
}
