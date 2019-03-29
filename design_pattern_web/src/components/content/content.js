import React,{Component} from 'react';
import {Layout, message, Modal, Table,Tooltip,Slider} from 'antd';
import MyModal from './my';
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
import {character_service} from "../service/character_service";
import "../../meterials/css/content.css"

const {
     Footer, Sider, Content,
} = Layout;

class PContent extends Component{
    constructor(props){
        super(props);
        this.state={
            userCharacterId:'',
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
            skill_data:[{skillId:'',characterId:''},{skillId:'',characterId:''},{skillId:'',characterId:''},{skillId:'',characterId:''}],
            random_1:[Math.random()*1300+100,Math.random()*500+60],
            random_2:[Math.random()*1300+100,Math.random()*500+60],
            random_3:[Math.random()*1300+100,Math.random()*500+60],
            random_4:[Math.random()*1300+100,Math.random()*500+60],
            random_5:[Math.random()*1300+100,Math.random()*500+60],
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
    }

    componentDidMount(){
        let userCharacterId=this.props.match.params.userCharacterId;
        this.obtain_skill(userCharacterId);
        this.obtain_weapon(userCharacterId);
        this.obtain_character_detail(userCharacterId);
        this.setState({
            userCharacterId:userCharacterId,
        })
        document.addEventListener("keydown",this.onKeyDown)
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

    obtain_weapon(userCharacterId){
        character_service.obtain_weapon(userCharacterId).then(response=>{
            if(response.code==="200"){
                console.log(response);
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
                            {this.state.skill_data[0].characterId===1&&
                            <img src={character_1} width="70px" height="70px" style={{float:'left'}}/>
                            }
                            {this.state.skill_data[0].characterId===2&&
                            <img src={character_2} width="70px" height="70px" style={{float:'left'}}/>
                            }
                            {this.state.skill_data[0].characterId===3&&
                            <img src={character_3} width="70px" height="70px" style={{float:'left'}}/>
                            }
                            <div style={{color:'white',width:'180px',textAlign:'center'}}>
                                <div style={{height:'50%',width:'100%',lineHeight:'35px'}}>
                                    角色昵称：
                                </div>
                                <div style={{height:'50%',width:'100%',lineHeight:'35px'}}>
                                    角色等级：
                                </div>
                            </div>
                        </div>
                        <div style={{position:'absolute',left:'25%',top:'30%',width:'150px',height:'200px', zIndex:'22'}}>
                            {this.state.skill_data[0].characterId===1&&
                                <div>
                                    <Slider defaultValue={100}  style={{color:'red'}}></Slider>
                                    <img src={character_1_1} width="100%" height="100%"/>
                                </div>
                            }
                            {this.state.skill_data[0].characterId===2&&
                            <div>
                                <Slider defaultValue={100}  style={{color:'red'}}></Slider>
                                <img src={character_2_1} width="100%" height="100%"/>
                            </div>

                            }
                            {this.state.skill_data[0].characterId===3&&
                            <div>
                                <Slider defaultValue={100}  style={{color:'red'}}></Slider>
                                <img src={character_3_1} width="100%" height="100%"/>
                            </div>
                            }
                        </div>
                        <Tooltip title="点击打怪">
                        <div style={{position:'absolute',left:this.state.random_1[0],top:this.state.random_1[1],width:'90px',height:'90px', zIndex:'22'}}>
                            <Slider defaultValue={30} style={{color:'red'}}></Slider>
                            <img src={monster1} height="100%" width="100%"/>
                        </div>
                        </Tooltip>
                        <Tooltip title="点击打怪">
                        <div style={{position:'absolute',left:this.state.random_2[0],top:this.state.random_2[1],width:'90px',height:'90px', zIndex:'22'}}>
                            <Slider defaultValue={80}  style={{color:'red'}}></Slider>
                            <img src={monster2} height="100%" width="100%"/>
                        </div>
                        </Tooltip>
                        <Tooltip title="点击打怪">
                        <div style={{position:'absolute',left:this.state.random_3[0],top:this.state.random_3[1],width:'90px',height:'90px', zIndex:'22'}}>
                            <Slider defaultValue={70}  style={{color:'red'}}></Slider>
                            <img src={monster3} height="100%" width="100%"/>
                        </div>
                        </Tooltip>
                        <Tooltip title="点击打怪">
                        <div style={{position:'absolute',left:this.state.random_4[0],top:this.state.random_4[1],width:'90px',height:'90px', zIndex:'22'}}>
                            <Slider defaultValue={50} style={{color:'red'}}></Slider>
                            <img src={monster4} height="100%" width="100%"/>
                        </div>
                        </Tooltip>
                        <Tooltip title="点击打怪">
                        <div style={{position:'absolute',left:this.state.random_5[0],top:this.state.random_5[1],width:'90px',height:'90px', zIndex:'22'}}>
                            <Slider defaultValue={90}  style={{color:'red'}}></Slider>
                            <img src={monster5} height="100%" width="100%"/>
                        </div>
                        </Tooltip>
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
                            <MyModal characterId={this.state.skill_data[0].characterId}/>
                        </Modal>
                        <Modal visible={this.state.visible_1} footer={null} closable={false} bsSize="large" onCancel={()=>{this.setState({visible_1:false})}}>forge</Modal>
                        <Modal visible={this.state.visible_2} footer={null} closable={false} bsSize="large" onCancel={()=>{this.setState({visible_2:false})}}>task</Modal>
                        <Modal visible={this.state.visible_3} footer={null} closable={false} bsSize="large" onCancel={()=>{this.setState({visible_3:false})}}>skill</Modal>
                        <Modal visible={this.state.visible_4} footer={null} closable={false} bsSize="large" onCancel={()=>{this.setState({visible_4:false})}}>bag</Modal>
                    </Content>
                </Layout>
            </div>
        )
    }
}

export default PContent;
