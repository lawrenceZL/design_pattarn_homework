import React, {Component} from 'react';
import {Form, Input, Tooltip, Icon, Cascader, Select, Row, Col, Checkbox, Button, AutoComplete,} from 'antd';
import Header from '../header/header';
import {user_service} from "../service/user_service";


const {Option} = Select.Option;
const AutoCompleteOption = AutoComplete.Option;

class Register extends Component {

    constructor(props){
        super(props);
        this.state = {
            email:'',
            phone:'',
            sex:'',
            name:'',
            password:'',
            confirm_password:'',
            // ready2send:false,
        };
        this.handleSubmit=this.handleSubmit.bind(this);
    }


    handleSubmit(){
        if(this.state.email!==""&&this.state.phone!==""&&this.state.sex!==""&&this.state.name!==""&&this.state.password!==""&&this.state.confirm_password!==""){
            if(this.state.password===this.state.confirm_password){
                user_service.register(this.state.name,this.state.password,this.state.sex,this.state.email,this.state.phone).then(response=>{
                    if(response.code==="200"){
                        window.location.href="/login"
                    }
                })
            }else{
                alert("请确认两次密码是否一致")
            }
        }else{
            alert("请填写完整注册信息")
        }

    }


    render() {

        const formItemLayout = {
            labelCol: {
                xs: {span: 24},
                sm: {span: 9},
            },
            wrapperCol: {
                xs: {span: 24},
                sm: {span: 6},
            },
        };
        const tailFormItemLayout = {
            wrapperCol: {
                xs: {
                    span: 24,
                    offset: 0,
                },
                sm: {
                    span: 16,
                    offset: 8,
                },
            },
        };

        return (
            <div>
                <Header/>
                <div style={{paddingTop: '40px'}}>
                    <Form {...formItemLayout}>
                        <Form.Item
                            label="邮箱"
                        >
                            <Input onChange={(e)=>{this.setState({email:e.target.value})}}/>
                        </Form.Item>
                        <Form.Item
                            label="手机号"
                        >
                            <Input onChange={(e)=>{this.setState({phone:e.target.value})}}/>
                        </Form.Item>
                        <Form.Item
                            label="性别"
                        >
                            <Input onChange={(e)=>{
                                if(e.target.value==="男"){
                                    this.setState({sex:"MALE"})
                                }else {
                                    this.setState({sex:"FEMALE"})
                                }
                            }}/>
                        </Form.Item>
                        <Form.Item
                            label={(
                                <span>用户名&nbsp;
                                    <Tooltip title="What do you want others to call you?"><Icon
                                        type="question-circle-o"/></Tooltip></span>
                            )}
                        >
                            <Input onChange={(e)=>{this.setState({name:e.target.value})}}/>
                        </Form.Item>
                        <Form.Item
                            label="密码"
                        >
                            <Input type="password" onChange={(e)=>{this.setState({password:e.target.value})}}/>
                        </Form.Item>
                        <Form.Item
                            label="确认密码"
                        >
                            <Input type="password" onChange={(e)=>{this.setState({confirm_password:e.target.value})}}/>
                        </Form.Item>
                        <Form.Item {...tailFormItemLayout}>
                            <Checkbox style={{marginLeft:'90px'}}>我已看过并接受<a href="">用户协议</a></Checkbox>
                            <Button style={{marginLeft:'30px'}} type="primary" onClick={this.handleSubmit}>注册</Button>
                        </Form.Item>
                        <Form.Item {...tailFormItemLayout}>
                            <a style={{marginLeft:'170px'}} href="/login">我已有账号，前往登录</a>
                        </Form.Item>
                    </Form></div>
            </div>

        );
    }
}

export default Register;
