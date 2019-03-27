package cn.edu.nju.software.design_pattern_homework_server.dao;

import cn.edu.nju.software.design_pattern_homework_server.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsernameIsOrMailIsOrTelIs(String username, String mail, String tel);

    List<User> findAllByUsernameIsOrMailIsOrTelIs(String username, String mail, String tel);

}
