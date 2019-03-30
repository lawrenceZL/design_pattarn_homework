package cn.edu.nju.software.design_pattern_homework_server.dao;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterEquipment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserCharacterEquipmentRepository extends CrudRepository<UserCharacterEquipment, Long> {
    List<UserCharacterEquipment> findAllByUserCharacterIdAndEquiped(Long userCharacterId, Boolean equiped);

    @Transactional
    @Modifying
    @Query("update #{#entityName} t set t.equiped = :equiped  where t.id = :id")
    void updateEquipedState(@Param("id") Long id, @Param("equiped") Boolean equiped);

    @Transactional
    @Modifying
    @Query("update #{#entityName} t set t.equiped = :equiped  where t.userCharacterId = :userCharacterId and t.type= :type")
    void updateEquipedStateByType(@Param("userCharacterId") Long userCharacterId, @Param("type") EQUIP_TYPE type, @Param("equiped") Boolean equiped);
}
