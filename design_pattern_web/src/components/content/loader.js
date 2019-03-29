import React,{Component} from 'react';
import { Layout,Radio,Button,Input} from 'antd';
import Header from '../header/header';
import  character_1 from '../../meterials/image/character1.png';
import  character_2 from '../../meterials/image/character2.png';
import  character_3 from '../../meterials/image/character3.png';
import {user_service} from "../service/user_service";


const {
    Footer, Sider, Content,
} = Layout;

class Loader extends Component{
    constructor(props){
        super(props);
        this.state={
            check_1:false,
            check_2:false,
            check_3:false,
            userId:'',
            nickname:'',
            c_name_1:'',
            c_name_2:'',
            c_name_3:'',
            id:'',
        }
        this.obtain_list=this.obtain_list.bind(this);
    }

    bind_character(userId,characterId,nickname){
        user_service.bind_character(userId,characterId,nickname).then(response=>{
            if(response.code==="200"){
                // console.log(response.data);
                window.location.href="/content/"+response.data.id
            }else {
                alert("失败，请重试")
            }
        })
    }

    componentDidMount(){
        let userId=this.props.match.params.userId;
        this.obtain_character_list();
        this.setState({
            userId:userId,
        })
    }

    obtain_character_list(userId){
        user_service.obtain_character_list().then(response=>{
            if(response.code==="200"){
                this.setState({
                    c_name_1:response.data[0].name,
                    c_name_2:response.data[1].name,
                    c_name_3:response.data[2].name,
                })
            }
        })
    }

    obtain_list(){
        if(this.state.check_1===false&&this.state.check_2===false&&this.state.check_3===false){
            alert("请选择角色")
        }else if(this.state.nickname===""){
            alert("请输入昵称")
        }else {
            this.bind_character(parseInt(this.state.userId),this.state.id,this.state.nickname);
            // window.location.href="/content/"+this.state.userId
        }
    }

    render(){
        return (
                <Layout>
                    <Header>Header</Header>
                    <Content style={{height:window.innerHeight}}>
                        <div style={{position:'fixed',left:'50%',top:'20%',width:'600px',height:'400px',marginLeft:'-300px'}}>
                            <div style={{float:'left',width:'200px',height:'400px',textAlign:'center'}}>
                                <img src={character_1} width="200px"/>
                                <Radio checked={this.state.check_1} style={{marginTop:'20px'}} onChange={()=>{this.setState({check_1:true, check_2:false, check_3:false,id:1})}}>{this.state.c_name_1}</Radio>
                            </div>
                            <div style={{float:'left',width:'200px',height:'400px',textAlign:'center'}}>
                                <img src={character_2} width="200px"/>
                                <Radio checked={this.state.check_2} style={{marginTop:'20px',marginBottom:'20px'}} onChange={()=>{this.setState({check_1:false, check_2:true, check_3:false,id:2})}}>{this.state.c_name_2}</Radio>
                                <br/>
                                <Input placeholder="创建角色昵称" style={{width:'150px',marginBottom:'20px'}} onChange={(e)=>{this.setState({nickname:e.target.value})}}/>
                                <Button type="primary" onClick={this.obtain_list}>确认载入</Button>
                            </div>
                            <div style={{float:'left',width:'200px',height:'400px',textAlign:'center'}}>
                                <img src={character_3} width="200px"/>
                                <Radio checked={this.state.check_3} style={{marginTop:'20px'}} onChange={()=>{this.setState({check_1:false, check_2:false, check_3:true,id:3})}}>{this.state.c_name_3}</Radio>
                            </div>
                        </div>
                    </Content>
                </Layout>

        )
    }
}

export default Loader;
