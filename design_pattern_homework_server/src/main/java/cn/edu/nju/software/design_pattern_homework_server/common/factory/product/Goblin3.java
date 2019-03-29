package cn.edu.nju.software.design_pattern_homework_server.common.factory.product;


import cn.edu.nju.software.design_pattern_homework_server.entity.base.CharacterBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Goblin3 extends GoblinCharacter {
    private int times = 3;
    @Override
    public void init(CharacterBaseEntity attrs) {
        this.setEXP(attrs.getEXP()*times/(3*3));
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
