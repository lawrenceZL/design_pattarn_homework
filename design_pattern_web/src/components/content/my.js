import React, {Component} from 'react';
import {Button,Tooltip} from 'antd'
import equip_1 from '../../meterials/image/equip1.png';
import equip_2 from '../../meterials/image/equip2.png';
import equip_3 from '../../meterials/image/equip3.png';
import equip_4 from '../../meterials/image/equip4.png';
import equip_5 from '../../meterials/image/equip5.png';
import equip_6 from '../../meterials/image/equip6.png';
import character_1 from '../../meterials/image/character1.png';
import character_2 from '../../meterials/image/character2.png';
import character_3 from '../../meterials/image/character3.png';
import weapon_1 from '../../meterials/image/weapon_1.png';
import {character_service} from "../service/character_service";

class MyModal extends Component {
    constructor(props) {
        super(props);
        this.state={
            character_data:props.character_data,
            userCharacterId:props.userCharacterId,
            weapon_data:"",
        }
    }
    componentWillMount(){
        this.obtain_weapon(this.state.userCharacterId);
        this.obtain_equip(this.state.userCharacterId,true)
    }

    componentWillReceiveProps(nextProps){
        this.obtain_weapon(nextProps.userCharacterId);
        this.obtain_equip(this.state.userCharacterId,true)
    }

    obtain_weapon(userCharacterId){
        character_service.obtain_weapon(userCharacterId).then(response=>{
            if(response.code==="200"){
                this.setState({
                    weapon_data:response.data,
                })
            }
        })
    }

    obtain_equip(userCharacterId,equiped){
        character_service.obtain_equip(userCharacterId,equiped).then(response=>{
            if(response.code==="200"){
                console.log(response);
            }
        })
    }

    render() {
        return (
            <div>
                <div style={{width: '472px'}}>
                    <div style={{height: '60px', backgroundColor: '#d9d9d9',color:'#996600',paddingTop:'5px',paddingBottom:'5px',borderBottom:'1px solid #996600'}}>
                        <div style={{height:'25px',textAlign:'center'}}>
                            <span>物理攻击：{this.state.character_data.ATN}</span>&nbsp;&nbsp;<span>魔法攻击：{this.state.character_data.INT}</span>&nbsp;&nbsp;<span>物理防御：{this.state.character_data.DEF}</span>
                        </div>
                        <div style={{height:'25px',textAlign:'center'}}>
                            <span>魔法防御：{this.state.character_data.RES}</span>&nbsp;&nbsp;<span>暴击率：{this.state.character_data.CRIT}</span>&nbsp;&nbsp;<span>暴击伤害：{this.state.character_data.CRIT_S}</span>
                        </div>
                    </div>
                    <div style={{height: '270px', backgroundColor: '#d9d9d9'}}>
                        <div style={{width: '90px', float: 'left'}}>
                            <div style={{width: '90px', height: '90px', padding: '10px'}}>
                                <div style={{ width: '100%', height: '100%'}}>
                                    <img src={equip_1} width="100%" height="100%"/>
                                </div>
                            </div>
                            <div style={{width: '90px', height: '90px', padding: '10px'}}>
                                <div style={{ width: '100%', height: '100%'}}>
                                    <img src={equip_2} width="100%" height="100%"/>
                                </div>
                            </div>
                            <div style={{width: '90px', height: '90px', padding: '10px'}}>
                                <div style={{width: '100%', height: '100%'}}>
                                    <img src={equip_3} width="100%" height="100%"/>
                                </div>
                            </div>
                        </div>
                        <div style={{width: '290px', height: '270px', paddingTop: '10px',paddingBottom:'10px',paddingLeft:'30px',paddingRight:'30px', float: 'left',borderLeft:'1px solid #996600',borderRight:'1px solid #996600'}}>
                            <div style={{height: '100%', width: '100%', }}>
                                {this.props.characterId===1&&
                                    <img src={character_1} width="100%" height="100%"/>
                                }
                                {this.props.characterId===2&&
                                <img src={character_2} width="100%" height="100%"/>
                                }
                                {this.props.characterId===3&&
                                <img src={character_3} width="100%" height="100%"/>
                                }
                            </div>
                        </div>
                        <div style={{width: '90px', float: 'left'}}>
                            <div style={{width: '90px', height: '90px', padding: '10px'}}>
                                <div style={{ width: '100%', height: '100%'}}>
                                    <img src={equip_4} width="100%" height="100%"/>
                                </div>
                            </div>
                            <div style={{width: '90px', height: '90px', padding: '10px'}}>
                                <div style={{ width: '100%', height: '100%'}}>
                                    <img src={equip_5} width="100%" height="100%"/>
                                </div>
                            </div>
                            <div style={{width: '90px', height: '90px', padding: '10px'}}>
                                <div style={{ width: '100%', height: '100%'}}>
                                    <img src={equip_6} width="100%" height="100%"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style={{height: '60px', width:'100%',paddingLeft:'80px',backgroundColor: '#d9d9d9',paddingTop:'10px',paddingBottom:'10px',borderTop:'1px solid #996600'}}>
                        <Tooltip title={this.state.weapon_data.name}><img src={weapon_1} height="100%" width="200px"/></Tooltip>
                        <Button style={{height:'100%',marginLeft:'20px',backgroundColor:'#cc9900'}}>升级武器</Button>
                    </div>
                </div>
            </div>
        )
    }
}

export default MyModal;
