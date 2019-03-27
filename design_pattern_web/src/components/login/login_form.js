import React from 'react'

import {Button,Form,FormControl,FormGroup,Panel} from 'react-bootstrap';
import { Modal,} from 'antd';

import Header from "../header/header";
import {user_service} from "../service/user_service";


class LoginForm extends React.Component {
    constructor(props) {
        super(props);

        this.process_username = this.process_username.bind(this);
        this.process_password = this.process_password.bind(this);
        this.validate = this.validate.bind(this);
        this.submit=this.submit.bind(this);

        this.state = {
            username: '',
            password: '',
            filled: false,
            visible:false,
        };
    }

    submit(){
        console.log(this.state.username+"  "+this.state.password)
        user_service.login(this.state.username,this.state.password).then(response=>{
            if(response.code==="200"){
                this.success();
                setTimeout(function () {
                    window.location.href="/loader"
                },5000)
            }
        })
    }

    success() {
        let modal=Modal.success({
            title: '登陆成功',
            content: '游戏载入中，请稍后...',
            okText:"退出"
        });
        setTimeout(function () {
            modal.destroy();
        },5000)
    }

    process_username(e) {
        this.setState({username: e.target.value}, this.validate)
    }

    process_password(e) {
        this.setState({password: e.target.value}, this.validate)
    }

    validate = () => {
        if (this.state.username !== '' && this.state.password !== '') {
            this.setState({filled: true});
        } else {
            this.setState({filled: false});
        }
    }


    render() {
        return (
            <div>
                <Header/>
                <Form>
                    <div className="form-signin">
                        <Panel>
                            <Panel.Heading>
                                <Panel.Title componentClass="h3">游戏平台登录</Panel.Title>
                            </Panel.Heading>
                            <Panel.Body>
                                <FormGroup bsClass="input-group form-line">
                                    <span className="input-group-addon"><i
                                        className="glyphicon glyphicon-user"></i></span>
                                    <FormControl type="text" value={this.state.username} placeholder="请输入用户名"
                                                 onChange={this.process_username}></FormControl>
                                    <FormControl.Feedback/>
                                </FormGroup>
                                <FormGroup bsClass="input-group form-line">
                                <span className="input-group-addon" id="sizing-addon1"><i
                                    className="glyphicon glyphicon-lock"></i></span>
                                    <FormControl type="password" value={this.state.password} placeholder="请输入账户密码"
                                                 onChange={this.process_password}></FormControl>
                                </FormGroup>
                                <Button className="btn-lg btn-block" bsStyle="primary" onClick={this.submit}
                                        disabled={!this.state.filled}>登录</Button>
                            </Panel.Body>
                        </Panel>
                        <div style={{textAlign:'center'}} onClick={()=>{window.location.href="/register"}}><a>没有账号,前往注册</a></div>
                    </div>
                </Form>
                {/*<Modal*/}
                    {/*visible={this.state.visible}*/}
                    {/*footer={null}*/}
                    {/*closable={false}*/}
                {/*>*/}
                    {/*<p>Some contents...</p>*/}
                    {/*<p>Some contents...</p>*/}
                    {/*<p>Some contents...</p>*/}
                {/*</Modal>*/}
            </div>
        );
    }
}

export default LoginForm
