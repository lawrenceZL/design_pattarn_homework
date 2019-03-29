package cn.edu.nju.software.design_pattern_homework_server.common.factory.product;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.GOBLIN_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.CharacterBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Goblin5 extends GoblinCharacter{
    private GOBLIN_TYPE type = GOBLIN_TYPE.GOBLIN5;
    private int times = 5;
    @Override
    public void init(CharacterBaseEntity attrs) {
        this.setEXP(attrs.getEXP()*times/3);
        this.setHP(attrs.getHP()*times);
        this.setMAG(attrs.getMAG()*times);
        this.setATN(attrs.getATN()*times/2);
        this.setCRIT(attrs.getCRIT()*times/2);
        this.setCRIT_S(attrs.getCRIT_S()*times/2);
        this.setDEF(attrs.getDEF()*times/2);
        this.setINT(attrs.getINT()*times/2);
        this.setRES(attrs.getRES()*times/2);
        this.setSPD(attrs.getSPD()*times/2);
    }
}
