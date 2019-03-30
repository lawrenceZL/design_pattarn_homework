import React,{Component} from 'react';
import {Tooltip,Popconfirm,message} from 'antd';
import equip_1 from '../../meterials/image/equip1.png';
import equip_2 from '../../meterials/image/equip2.png';
import equip_3 from '../../meterials/image/equip3.png';
import equip_4 from '../../meterials/image/equip4.png';
import equip_5 from '../../meterials/image/equip5.png';
import equip_6 from '../../meterials/image/equip6.png';
import {character_service} from "../service/character_service";

class Bag extends Component{
    constructor(props){
        super(props);
        this.state={
            userCharacterId:props.userCharacterId,
            equipment_data:[],
        }
        this.change_equipment=this.change_equipment.bind(this);
        this.upgrade_equipment=this.upgrade_equipment.bind(this);
    }

    judge_pic(type){
        switch (type) {
            case "HEAD":
                return equip_1
            case "HAND":
                return equip_2
            case "MASK":
                return equip_3
            case "BODY":
                return equip_4
            case "LEG":
                return equip_5
            case "FOOT":
                return equip_6
        }
    }

    componentWillMount(){
        this.obtain_equipment(this.state.userCharacterId);
    }

    componentWillReceiveProps(nextProps){
        this.obtain_equipment(nextProps.userCharacterId);
    }

    change_equipment(item,index){
        character_service.change_equipment(item.id,null).then(response=>{
            if(response.code==="200"){
                message.success("装备成功！")
                let equipment_data=this.state.equipment_data;
                equipment_data[index]=response.data;
                this.setState({
                    equipment_data:equipment_data,
                })
            }
        })
    }

    upgrade_equipment(item){
        console.log(item)
        character_service.upgrade_equipment(item.id,this.state.userCharacterId,item.upgradeTimes).then(response=>{
            if(response.code==="200"){
                message.success("升级成功！")
            }else if(response.code==="500"){
                message.error(response.message);
            }
        })
    }

    obtain_equipment(userCharacterId){
        character_service.obtain_equip(userCharacterId,false).then(response=>{
            if(response.code==="200"){
                this.setState({
                    equipment_data:response.data,
                })
            }
        })
    }

    render(){
        return (
            <div style={{width:'100%',height:'340px',overflow: 'scroll',textAlign:'center'}}>
                <div style={{color:'#996600',width:'100%',fontSize:'20px',borderBottom:'1px solid #996600'}}>背包装备列表</div>
                {this.state.equipment_data.map((item,index)=>{
                    // console.log(item);
                    return(
                        <Tooltip title={item.upgradeTimes+"级的"+item.name} key={index}>
                            <Popconfirm title="请选择操作：" okText="升级" cancelText="装备" placement="right" onCancel={()=>{this.change_equipment(item)}} onConfirm={()=>{this.upgrade_equipment(item)}}>
                            <div style={{width:'110px',height:'110px',float:'left',padding:'10px'}}>
                                <img src={this.judge_pic(item.type)} width="100%" height="100%"/>
                            </div>
                            </Popconfirm>
                        </Tooltip>
                    )
                })
                }
            </div>
        )
    }
}

export default Bag;
