package cn.edu.nju.software.design_pattern_homework_server.controller;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.INIT_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.service.InitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/init")
public class InitController {

    @Resource
    private InitService initService;

    @GetMapping
    public Result init(@RequestParam(value = "type", required = false) INIT_TYPE type) {
        if (null == type) {
            type = INIT_TYPE.ALL;
        }
        switch (type) {
            case ALL:
                initService.initAll();
                break;
            case WEAPON:
                initService.initWeapon();
                break;

            case SKILL:
                initService.initSkill();
                break;

            case CHARACTER:
                initService.initCharacter();
                break;

            case EQUIPMENT:
                initService.initEquipment();
                break;
            default:
                initService.initAll();
        }
        return Result.success().message("初始化数据成功！");
    }
}
