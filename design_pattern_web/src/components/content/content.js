import React,{Component} from 'react';
import {Layout, message, Modal, Table,Tooltip,Slider} from 'antd';
import MyModal from './my';
import Bag from './bag';
import Task from './task';
import Forge from './forge';
import character_1 from '../../meterials/image/character1.png';
import character_2 from '../../meterials/image/character2.png';
import character_3 from '../../meterials/image/character3.png';
import character_1_1 from '../../meterials/image/character1_1.png';
import character_2_1 from '../../meterials/image/character2_1.png';
import character_3_1 from '../../meterials/image/character3_1.png';
import background from '../../meterials/image/background.png';
import bag from '../../meterials/image/bag.png';
import skill from '../../meterials/image/skill.png';
import task from '../../meterials/image/task.png';
import forge from '../../meterials/image/forge.png';
import skill_1_1 from '../../meterials/image/skill_1_1.png';
import skill_1_2 from '../../meterials/image/skill_1_2.png';
import skill_1_3 from '../../meterials/image/skill_1_3.png';
import skill_1_4 from '../../meterials/image/skill_1_4.png';
import skill_2_1 from '../../meterials/image/skill_2_1.png';
import skill_2_2 from '../../meterials/image/skill_2_2.png';
import skill_2_3 from '../../meterials/image/skill_2_3.png';
import skill_2_4 from '../../meterials/image/skill_2_4.png';
import skill_3_1 from '../../meterials/image/skill_3_1.png';
import skill_3_2 from '../../meterials/image/skill_3_2.png';
import skill_3_3 from '../../meterials/image/skill_3_3.png';
import skill_3_4 from '../../meterials/image/skill_3_4.png';
import monster1 from '../../meterials/image/monster1.png';
import monster2 from '../../meterials/image/monster2.png';
import monster3 from '../../meterials/image/monster3.png';
import monster4 from '../../meterials/image/monster4.png';
import monster5 from '../../meterials/image/monster5.png';
import trea from '../../meterials/image/treasure.png';
import trea_open from '../../meterials/image/treasure_open.png';
import {character_service} from "../service/character_service";
import "../../meterials/css/content.css"
import Skill from "./skill";

const {
     Footer, Sider, Content,
} = Layout;

class PContent extends Component{
    constructor(props){
        super(props);
        this.state={
            userCharacterId:'',
            character_data:[],
            monster_data:[],
            trea_open:false,
            treasure:'',
            skill_1_use:'',
            skill_2_use:'',
            skill_3_use:'',
            skill_4_use:'',
            skill_1_time:"",
            skill_2_time:"",
            skill_3_time:"",
            skill_4_time:"",
            visible:false,
            visible_1:false,
            visible_2:false,
            visible_3:false,
            visible_4:false,
            random_1:[Math.random()*1300+100,Math.random()*500+50],
            random_2:[Math.random()*1300+100,Math.random()*500+50],
            random_3:[Math.random()*1300+100,Math.random()*500+50],
            random_4:[Math.random()*1300+100,Math.random()*500+50],
            random_5:[Math.random()*1300+100,Math.random()*500+50],
            random_6:[Math.random()*1300+100,Math.random()*500+50],
            random_7:[Math.random()*1300+100,Math.random()*500+50],
            random_8:[Math.random()*1300+100,Math.random()*500+50],
            random_9:[Math.random()*1300+100,Math.random()*500+50],
            random_10:[Math.random()*1300+100,Math.random()*500+50],
            random_11:[Math.random()*1300+100,Math.random()*500+50],
            random_12:[Math.random()*1300+100,Math.random()*500+50],
            random_13:[Math.random()*1300+100,Math.random()*500+50],
            value_1:100,
            value_2:100,
            value_3:100,
            value_4:100,
            value_5:100,
            value_6:100,
            value_7:100,
            value_8:100,
            value_9:100,
            value_10:100,
            value_11:100,
            value_12:100,
            value_13:100,
            value_c:100,
            skill_data:[{skillId:'',characterId:''},{skillId:'',characterId:''},{skillId:'',characterId:''},{skillId:'',characterId:''}],
        }
        this.onKeyDown=this.onKeyDown.bind(this);
        this.visible_click=this.visible_click.bind(this);
        this.visible_1_click=this.visible_1_click.bind(this);
        this.visible_2_click=this.visible_2_click.bind(this);
        this.visible_3_click=this.visible_3_click.bind(this);
        this.visible_4_click=this.visible_4_click.bind(this);
        this.use_skill_1=this.use_skill_1.bind(this);
        this.use_skill_2=this.use_skill_2.bind(this);
        this.use_skill_3=this.use_skill_3.bind(this);
        this.use_skill_4=this.use_skill_4.bind(this);
        this.treasure_click=this.treasure_click.bind(this);
        this.monster_click=this.monster_click.bind(this);
    }
    componentWillMount(){
        let userCharacterId=this.props.match.params.userCharacterId;
        this.obtain_character_info(userCharacterId);
        this.create_monster(userCharacterId);
    }

    componentDidMount(){
        let userCharacterId=this.props.match.params.userCharacterId;
        this.things_drop();
        // setInterval(()=>{this.things_drop()},2000);
        this.obtain_skill(userCharacterId);
        this.obtain_character_detail(userCharacterId);
        this.setState({
            userCharacterId:userCharacterId,
        })
        document.addEventListener("keydown",this.onKeyDown)
    }
    create_monster(userCharacterId){
        character_service.create_monster(userCharacterId).then(response=>{
            if(response.code==="200"){
                this.setState({
                    monster_data:response.data
                })
            }
        })
    }

    judge_monster(times){
        switch (times) {
            case 1:
                return monster1
            case 2:
                return monster2
            case 3:
                return monster3
            case 4:
                return monster4
            case 5:
                return monster5
        }
    }

    left_position_random(index){
        switch (index) {
            case 1:
                return this.state.random_1[0]
            case 2:
                return this.state.random_2[0]
            case 3:
                return this.state.random_3[0]
            case 4:
                return this.state.random_4[0]
            case 5:
                return this.state.random_5[0]
            case 6:
                return this.state.random_6[0]
            case 7:
                return this.state.random_7[0]
            case 8:
                return this.state.random_8[0]
            case 9:
                return this.state.random_9[0]
            case 10:
                return this.state.random_10[0]
            case 11:
                return this.state.random_11[0]
            case 12:
                return this.state.random_12[0]
            case 13:
                return this.state.random_13[0]
        }
    }

    top_position_random(index){
        switch (index) {
            case 1:
                return this.state.random_1[1]
            case 2:
                return this.state.random_2[1]
            case 3:
                return this.state.random_3[1]
            case 4:
                return this.state.random_4[1]
            case 5:
                return this.state.random_5[1]
            case 6:
                return this.state.random_6[1]
            case 7:
                return this.state.random_7[1]
            case 8:
                return this.state.random_8[1]
            case 9:
                return this.state.random_9[1]
            case 10:
                return this.state.random_10[1]
            case 11:
                return this.state.random_11[1]
            case 12:
                return this.state.random_12[1]
            case 13:
                return this.state.random_13[1]
        }
    }

    blood_value(index){
        switch (index) {
            case 0:
                return this.state.value_1
            case 1:
                return this.state.value_2
            case 2:
                return this.state.value_3
            case 3:
                return this.state.value_4
            case 4:
                return this.state.value_5
            case 5:
                return this.state.value_6
            case 6:
                return this.state.value_7
            case 7:
                return this.state.value_8
            case 8:
                return this.state.value_9
            case 9:
                return this.state.value_10
            case 10:
                return this.state.value_11
            case 11:
                return this.state.value_12
            case 12:
                return this.state.value_13
        }
    }

    monster_click(item,index){
        // console.log(item+""+index);
        // console.log(this.state);
        if(this.blood_value(index)<=0){
            message.error("当前小怪已死亡，请更换目标")
        }else{
            this.set_blood(index+1,this.blood_down(item.times));
            this.set_blood(0,this.blood_down(0));
            this.attack(true,item,this.state.userCharacterId,null,this.random_type());
            this.attack(false,item,this.state.userCharacterId,null,this.random_type());
            message.info("你攻击了小怪，造成了"+this.blood_down(item.times)+"点伤害，小怪拼死反击，对你造成"+this.blood_down(0)+"点伤害")
        }
    }

    random_type(){
        let num=Math.random();
        if(num<0.5){
            return "ATN"
        }else{
            return "INT"
        }
    }

    set_blood(index,down){
        switch (index) {
            case 0:{
                if(this.state.value_c-down<=0){
                    message.info("当前角色已死,5秒后返回登录界面重新开始游戏")
                    setTimeout(()=>{window.location.href="/login"},5000)
                }
                this.setState({value_c:this.state.value_c-down})
                break;
            }
            case 1:{
                if(this.state.value_1-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_1:this.state.value_1-down})
                break;
            }
            case 2:{
                if(this.state.value_2-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_2:this.state.value_2-down})
                break;
            }
            case 3:{
                if(this.state.value_3-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_3:this.state.value_3-down})
                break;
            }
            case 4:{
                if(this.state.value_4-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_4:this.state.value_4-down})
                break;
            }
            case 5:{
                if(this.state.value_5-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_5:this.state.value_5-down})
                break;
            }
            case 6:{
                if(this.state.value_6-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_6:this.state.value_6-down})
                break;
            }
            case 7:{
                if(this.state.value_7-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_7:this.state.value_7-down})
                break;
            }
            case 8:{
                if(this.state.value_8-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_8:this.state.value_8-down})
                break;
            }
            case 9:{
                if(this.state.value_9-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_9:this.state.value_9-down})
                break;
            }
            case 10:{
                if(this.state.value_10-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_10:this.state.value_10-down})
                break;
            }
            case 11:{
                if(this.state.value_11-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_11:this.state.value_11-down})
                break;
            }
            case 12:{
                if(this.state.value_12-down<=0){
                    message.success("恭喜你成功击杀小怪，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_12:this.state.value_12-down})
                break;
            }
            case 13:{
                if(this.state.value_13-down<=0){
                    message.info("小怪死亡，接下来击杀未死亡的小怪吧")
                }
                this.setState({value_13:this.state.value_13-down})
                break;
            }

        }
    }

    blood_down(index){
        switch (index) {
            case 0:
                return 2;
            case 1:
                return 50;
            case 2:
                return 25;
            case 3:
                return 20;
            case 4:
                return 10;
            case 5:
                return 5;
        }
    }


    attack(flag,goblin,userCharacterId,skillId,type){
        character_service.attack(flag,goblin,userCharacterId,skillId,type).then(response=>{
            if(response.code==="200"){
                console.log(response);
            }
        })
    }

    things_drop(){
        character_service.things_drop().then(response=>{
            if(response.code==="200"){
                console.log(response);
                this.setState({
                    treasure:response.data,
                })
            }
        })
    }

    thing_pick(userCharacterId,weaponCoupon,equipmentCoupon,equipments){
        character_service.things_pick(userCharacterId,weaponCoupon,equipmentCoupon,equipments).then(response=>{
            if(response.code==="200"){
                console.log(response.data);
                this.setState({trea_open:true});
                message.success(this.treasure_info(this.state.treasure))
                setTimeout(()=>{this.setState({trea_open:false})},2000)
            }
        })
    }
    obtain_character_info(userCharacterId){
        character_service.obtain_character_info(userCharacterId).then(response=>{
            if(response.code==="200"){
                console.log(response)
                this.setState({
                    character_data:response.data,
                })
            }
        })
    }

    obtain_character_detail(userCharacterId){
        character_service.obtain_character_detail(userCharacterId).then(response=>{
            if(response.code==="200"){
                console.log(response);
            }
        })
    }

    obtain_skill(userCharacterId){
        let skill_data=[];
        character_service.obtain_skill(userCharacterId).then(response=>{
            if(response.code==="200"){
                for(let i=0;i<response.data.length;i++){
                    let json={};
                    json['name']=response.data[i].name;
                    json['skillId']=response.data[i].skillId;
                    json['characterId']=response.data[i].characterId;
                    skill_data.push(json);
                }
                this.setState({
                    skill_data:skill_data,
                })
            }
        })
    }

    onKeyDown(e){
        switch( e.keyCode) {
            case 81:{
                this.use_skill_1();
                break;
            }
            case 87:{
                this.use_skill_2();
                break;
            }
            case 69:{
                this.use_skill_3();
                break;
            }
            case 82:{
                this.use_skill_4();
                break;
            }
            case 65:{
                this.visible_4_click();
                break;
            }
            case 83:{
                this.visible_3_click();
                break;
            }
            case 68:{
                this.visible_2_click();
                break;
            }
            case 70:{
                this.visible_1_click();
                break;
            }
        }
    }

    use_skill_1(){
        if(this.state.skill_1_time!==""){
            return;
        }
        message.success("你成功使用了技能："+this.state.skill_data[0].name);
        let init=5;
        this.setState({
            skill_1_use:"skill_use",
            skill_1_time:init,
        })
        let interval=setInterval(()=>{
            init=this.init_time(init);
            this.setState({
                skill_1_time:init,
            })
        },1000);
        setTimeout(()=> {
            clearInterval(interval);
            this.setState({
                skill_1_use:"",
                skill_1_time:"",
            });
        },init*1000);
    }

    use_skill_2(){
        if(this.state.skill_2_time!==""){
            return;
        }
        message.success("你成功使用了技能："+this.state.skill_data[1].name);
        let init=6;
        this.setState({
            skill_2_use:"skill_use",
            skill_2_time:init,
        })
        let interval=setInterval(()=>{
            init=this.init_time(init);
            this.setState({
                skill_2_time:init,
            })
        },1000);
        setTimeout(()=> {
            clearInterval(interval);
            this.setState({
                skill_2_use:"",
                skill_2_time:"",
            });
        },init*1000);
    }

    use_skill_3(){
        if(this.state.skill_3_time!==""){
            return;
        }
        message.success("你成功使用了技能："+this.state.skill_data[2].name);
        let init=7;
        this.setState({
            skill_3_use:"skill_use",
            skill_3_time:init,
        })
        let interval=setInterval(()=>{
            init=this.init_time(init);
            this.setState({
                skill_3_time:init,
            })
        },1000);
        setTimeout(()=> {
            clearInterval(interval);
            this.setState({
                skill_3_use:"",
                skill_3_time:"",
            });
        },init*1000);
    }

    use_skill_4(){
        if(this.state.skill_4_time!==""){
            return;
        }
        message.success("你成功使用了技能："+this.state.skill_data[3].name);
        let init=8;
        this.setState({
            skill_4_use:"skill_use",
            skill_4_time:init,
        })
        let interval=setInterval(()=>{
            init=this.init_time(init);
            this.setState({
                skill_4_time:init,
            })
        },1000);
        setTimeout(()=> {
            clearInterval(interval);
            this.setState({
                skill_4_use:"",
                skill_4_time:"",
            });
        },init*1000);
    }

    treasure_click(){
        if(this.state.trea_open===true){
            message.info("宝箱已被开过！")
        }else {
            if(this.state.treasure===""){
                message.error("很遗憾，宝箱里什么也没有！")
            }else {
                this.thing_pick(this.state.userCharacterId,this.state.treasure.weaponCoupon,this.state.treasure.equipmentCoupon,this.state.treasure.equipments);
            }
        }
    }

    treasure_info(treasure){
        let str="恭喜你，获得了";
        if(treasure.equipmentCoupon!==0){
            str+=treasure.equipmentCoupon+"张装备升级券，"
        }
        if(treasure.equipments.length!==0){
            for(let i=0;i<treasure.equipments.length;i++){
                str+="一件"+treasure.equipments.level+"的"+treasure.equipments.name+","
            }
        }
        if(treasure.weaponCoupon!==0){
            str+=treasure.weaponCoupon+"张武器升级券，"
        }
        return str;
    }

    visible_click(){
        this.setState({
            visible:true,
        })
    }
    visible_1_click(){
        this.setState({
            visible_1:true,
            visible_2:false,
            visible_3:false,
            visible_4:false,
        })
    }
    visible_2_click(){
        this.setState({
            visible_2:true,
            visible_1:false,
            visible_3:false,
            visible_4:false,
        })
    }
    visible_3_click(){
        this.setState({
            visible_3:true,
            visible_1:false,
            visible_2:false,
            visible_4:false,
        })
    }
    visible_4_click(){
        this.setState({
            visible_4:true,
            visible_1:false,
            visible_2:false,
            visible_3:false,
        })
    }

    init_time(n){
        return parseInt(n)-1;
    }

    render(){
        const num_style={
            position:'absolute', zIndex:22,left:'25px' ,top:'5px'
        }
        return (
            <div>
                <Layout>
                    <Content style={{height:window.innerHeight,width:window.innerWidth}}>
                        <div style={{height:'100%',width:'100%'}}>
                            <img src={background} width="100%" height="100%"/>
                        </div>
                        <div style={{position:'absolute',left:'30px',top:'30px',width:'250px',height:'70px',backgroundColor:'#808080', zIndex:'20'}} onClick={this.visible_click}>
                            <div style={{float:'left',width:'70px',height:'70px'}}>
                            {this.state.skill_data[0].characterId===1&&
                                <img src={character_1} width="70px" height="70px" />
                            }
                            {this.state.skill_data[0].characterId===2&&
                            <img src={character_2} width="70px" height="70px" />
                            }
                            {this.state.skill_data[0].characterId===3&&
                            <img src={character_3} width="70px" height="70px" />
                            }
                            </div>
                            <div style={{color:'white',width:'180px',float:'right',paddingLeft:'25px'}}>
                                <div style={{height:'50%',width:'100%',lineHeight:'35px'}}>
                                    角色昵称：{this.state.character_data.nickname}
                                </div>
                                <div style={{height:'50%',width:'100%',lineHeight:'35px'}}>
                                    角色等级：{this.state.character_data.level}
                                </div>
                            </div>
                        </div>
                        <div style={{position:'absolute',left:'25%',top:'30%',width:'150px',height:'200px', zIndex:'22'}}>
                            {this.state.skill_data[0].characterId===1&&
                                <div>
                                    <Slider value={this.state.value_c}  style={{color:'red'}}></Slider>
                                    <img src={character_1_1} width="100%" height="100%"/>
                                </div>
                            }
                            {this.state.skill_data[0].characterId===2&&
                            <div>
                                <Slider value={this.state.value_c}  style={{color:'red'}}></Slider>
                                <img src={character_2_1} width="100%" height="100%"/>
                            </div>

                            }
                            {this.state.skill_data[0].characterId===3&&
                            <div>
                                <Slider value={this.state.value_c}  style={{color:'red'}}></Slider>
                                <img src={character_3_1} width="100%" height="100%"/>
                            </div>
                            }
                        </div>
                        <div style={{position:'absolute',left:'50%',bottom:'40px',width:'130px',zIndex:'22',marginLeft:'-65px'}} onClick={this.treasure_click}>
                            {this.state.trea_open&&
                                <img src={trea_open} width="100%"/>
                            }
                            {!this.state.trea_open&&
                                <img src={trea} width="100%"/>
                            }
                        </div>
                        {this.state.monster_data.length===0?null:
                            this.state.monster_data.map((item,index)=>{
                            return (
                            <Tooltip title="点击打怪" key={index}>
                            <div style={{position:'absolute',left:this.left_position_random(index+1),top:this.top_position_random(index+1),width:'90px',height:'90px', zIndex:'22'}} onClick={()=>{this.monster_click(item,index)}}>
                            <Slider value={this.blood_value(index)} style={{color:'red'}}></Slider>
                            <img src={this.judge_monster(item.times)} height="100%" width="100%"/>
                            </div>
                            </Tooltip>
                            )
                        },this)
                        }

                        <Tooltip title="快捷键F">
                        <div style={{position:'absolute',right:'30px',bottom:'30px',width:'70px',height:'70px',backgroundColor:'red', zIndex:'20'}} onClick={this.visible_1_click}>
                            <img src={forge} width="70px" height="70px"/>
                        </div>
                        </Tooltip>
                        <Tooltip title="快捷键D">
                        <div style={{position:'absolute',right:'130px',bottom:'30px',width:'70px',height:'70px',backgroundColor:'red', zIndex:'20'}} onClick={this.visible_2_click}>
                            <img src={task} width="70px" height="70px"/>
                        </div>
                        </Tooltip>
                        <Tooltip title="快捷键S">
                        <div style={{position:'absolute',right:'230px',bottom:'30px',width:'70px',height:'70px',backgroundColor:'red', zIndex:'20'}} onClick={this.visible_3_click}>
                            <img src={skill} width="70px" height="70px"/>
                        </div>
                        </Tooltip>
                        <Tooltip title="快捷键A">
                        <div style={{position:'absolute',right:'330px',bottom:'30px',width:'70px',height:'70px',backgroundColor:'red', zIndex:'20'}} onClick={this.visible_4_click}>
                            <img src={bag} width="70px" height="70px"/>
                        </div>
                        </Tooltip>
                        <Tooltip title="快捷键Q">
                        <div style={{position:'absolute',left:'30px',bottom:'30px',width:'60px',height:'60px', zIndex:'20',borderRadius:'100%',color:'white',lineHeight:'60px',textAlign:'center'}} onClick={this.use_skill_1}>
                            {this.state.skill_data[0].skillId===1&&
                            <img className={this.state.skill_1_use} src={skill_1_1} width="100%" height="100%"/>
                            }
                            {this.state.skill_data[0].skillId===5&&
                            <img className={this.state.skill_1_use} src={skill_2_1} width="100%" height="100%"/>
                            }
                            {this.state.skill_data[0].skillId===9&&
                            <img className={this.state.skill_1_use} src={skill_3_1} width="100%" height="100%"/>
                            }
                            <div style={num_style}>{this.state.skill_1_time}</div>
                        </div>
                        </Tooltip>
                        <Tooltip title="快捷键W">
                        <div style={{position:'absolute',left:'120px',bottom:'30px',width:'60px',height:'60px',zIndex:'20',borderRadius:'100%',color:'white',lineHeight:'60px',textAlign:'center'}} onClick={this.use_skill_2}>
                            {this.state.skill_data[1].skillId===2&&
                            <img className={this.state.skill_2_use} src={skill_1_2} width="100%" height="100%"/>
                            }
                            {this.state.skill_data[1].skillId===6&&
                            <img className={this.state.skill_2_use} src={skill_2_2} width="100%" height="100%"/>
                            }
                            {this.state.skill_data[1].skillId===10&&
                            <img className={this.state.skill_2_use} src={skill_3_2} width="100%" height="100%"/>
                            }
                            <div style={num_style}>{this.state.skill_2_time}</div>
                        </div>
                        </Tooltip>
                        <Tooltip title="快捷键E">
                        <div style={{position:'absolute',left:'210px',bottom:'30px',width:'60px',height:'60px', zIndex:'20',borderRadius:'100%',color:'white',lineHeight:'60px',textAlign:'center'}} onClick={this.use_skill_3}>
                            {this.state.skill_data[2].skillId===3&&
                            <img className={this.state.skill_3_use} src={skill_1_3} width="100%" height="100%"/>
                            }
                            {this.state.skill_data[2].skillId===7&&
                            <img className={this.state.skill_3_use} src={skill_2_3} width="100%" height="100%"/>
                            }
                            {this.state.skill_data[2].skillId===11&&
                            <img className={this.state.skill_3_use} src={skill_3_3} width="100%" height="100%"/>
                            }
                            <div style={num_style}>{this.state.skill_3_time}</div>
                        </div>
                        </Tooltip>
                        <Tooltip title="快捷键R">
                        <div style={{position:'absolute',left:'300px',bottom:'30px',width:'60px',height:'60px',background:'rgba(0,0,0,0.3)', zIndex:'20',borderRadius:'100%',color:'white',lineHeight:'60px',textAlign:'center'}} onClick={this.use_skill_4}>
                            {this.state.skill_data[3].skillId===4&&
                            <img className={this.state.skill_4_use} src={skill_1_4} width="100%" height="100%"/>
                            }
                            {this.state.skill_data[3].skillId===8&&
                            <img className={this.state.skill_4_use} src={skill_2_4} width="100%" height="100%"/>
                            }
                            {this.state.skill_data[3].skillId===12&&
                            <img className={this.state.skill_4_use} src={skill_3_4} width="100%" height="100%"/>
                            }
                            <div style={num_style}>{this.state.skill_4_time}</div>
                        </div>
                        </Tooltip>
                        <Modal visible={this.state.visible} footer={null} closable={false} onCancel={()=>{this.setState({visible:false})}}>
                            <MyModal userCharacterId={this.state.userCharacterId} characterId={this.state.skill_data[0].characterId} character_data={this.state.character_data}/>
                        </Modal>
                        <Modal visible={this.state.visible_1} footer={null} closable={false} bsSize="large" onCancel={()=>{this.setState({visible_1:false})}}>
                            <Forge/>
                        </Modal>
                        <Modal visible={this.state.visible_2} footer={null} closable={false} bsSize="large" onCancel={()=>{this.setState({visible_2:false})}}>
                            <Task/>
                        </Modal>
                        <Modal visible={this.state.visible_3} footer={null} closable={false} bsSize="large" onCancel={()=>{this.setState({visible_3:false})}}>
                            <Skill/>
                        </Modal>
                        <Modal visible={this.state.visible_4} footer={null} closable={false} bsSize="large" onCancel={()=>{this.setState({visible_4:false})}}>
                            <Bag/>
                        </Modal>
                    </Content>
                </Layout>
            </div>
        )
    }
}

export default PContent;
