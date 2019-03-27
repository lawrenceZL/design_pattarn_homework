package cn.edu.nju.software.design_pattern_homework_server.dao;


import cn.edu.nju.software.design_pattern_homework_server.entity.Weapon;
import org.springframework.data.repository.CrudRepository;

public interface WeaponRepository extends CrudRepository<Weapon, Long> {

    Weapon findByCharacterId(Long id);
}
