package cn.edu.nju.software.design_pattern_homework_server.dao;

import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterEquipment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

public interface UserCharacterEquipmentRepository extends CrudRepository<UserCharacterEquipment, Long> {
}
