package cn.edu.nju.software.design_pattern_homework_server.dao;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.entity.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
    @Query(value = "select max(id) from #{#entityName}")
    Long maxId();

    @Query(value = "select min(id) from #{#entityName}")
    Long minId();

    List<Equipment> findAllByCharacterId(Long characterId);

    List<Equipment> findAllByType(EQUIP_TYPE type);

    List<Equipment> findAllByLevel(EQUIP_LEVEL level);

    List<Equipment> findAllByLevelAndCharacterId(EQUIP_LEVEL level, Long characterId);

    List<Equipment> findAllByLevelAndType(EQUIP_LEVEL level, EQUIP_TYPE type);

    List<Equipment> findAllByTypeAndCharacterId(EQUIP_TYPE type, Long characterId);

    List<Equipment> findAllByCharacterIdAndTypeAndLevel(Long characterId, EQUIP_TYPE type, EQUIP_LEVEL level);


}
