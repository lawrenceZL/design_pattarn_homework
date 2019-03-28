package cn.edu.nju.software.design_pattern_homework_server.dto;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SKILL_LEVEL;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SkillDto extends AttrDto{
    private String name;

    private Long characterId;

    private SKILL_LEVEL skillLevel;
}
