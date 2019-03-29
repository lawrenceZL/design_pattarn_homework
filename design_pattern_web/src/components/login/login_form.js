import React from 'react'

import {Button, Form, FormControl, FormGroup, Panel} from 'react-bootstrap';
import {Modal, Table} from 'antd';

import Header from "../header/header";
import {user_service} from "../service/user_service";
import "../../meterials/css/login.css";

const columns = [{
    title: '序号',
    dataIndex: 'num',
    key: 'num',
}, {
    title: '角色',
    dataIndex: 'character',
    key: 'character',
}, {
    title: '等级',
    dataIndex: 'level',
    key: 'level',
}, {
    title: '角色名',
    dataIndex: 'nickname',
    key: 'nickname',
}, {
    title: '创建时间',
    dataIndex: 'time',
    key: 'time',
}
];

class LoginForm extends React.Component {
    constructor(props) {
        super(props);

        this.process_username = this.process_username.bind(this);
        this.process_password = this.process_password.bind(this);
        this.validate = this.validate.bind(this);
        this.submit = this.submit.bind(this);

        this.state = {
            username: '',
            password: '',
            filled: false,
            visible: false,
            userId: '',
            dataSource: [],
        };
    }

    submit() {
        console.log(this.state.username + "  " + this.state.password)
        user_service.login(this.state.username, this.state.password).then(response => {
            if (response.code === "200") {
                this.setState({
                    userId: response.data.id,
                    visible: true,
                })
                // this.success(response.data.id);
                this.obtain_game_list(response.data.id);
                // setTimeout(function () {
                //     window.location.href="/loader"
                // },5000)
            } else {
                alert("登录失败，账号或密码错误")
            }
        })
    }

    obtain_game_list(userId) {
        let dataSource = [];
        user_service.obtain_game_list(userId).then(response => {
            if (response.code === "200") {
                console.log(response);
                for (let i = 0; i < response.data.length; i++) {
                    let json = {};
                    json['key'] = i;
                    json['num'] = i + 1;
                    json['character'] = response.data[i].name;
                    json['level'] = response.data[i].level;
                    json['nickname'] = response.data[i].nickname;
                    json['time']=response.data[i].createTime;
                    json['user_character_id']=response.data[i].id;
                    dataSource.push(json);
                }
                this.setState({
                    dataSource: dataSource,
                })
            }
        })
    }

    // success(id) {
    //     let modal=Modal.success({
    //         title: '登陆成功,请选择',
    //         content:
    //             <div>
    //
    //             </div>,
    //         okText:"退出"
    //     });
    //     // setTimeout(function () {
    //     //     modal.destroy();
    //     // },5000)
    // }

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
                        <div style={{textAlign: 'center'}} onClick={() => {
                            window.location.href = "/register"
                        }}><a>没有账号,前往注册</a></div>
                    </div>
                </Form>
                <Modal
                    visible={this.state.visible}
                    // footer={null}
                    closable={false}
                    bsSize="large"
                    onCancel={() => {
                        this.setState({visible: false})
                    }}
                    okText="创建新游戏"
                    onOk={() => {
                        window.location.href = "/loader/" + this.state.userId
                    }}
                >
                    <Table columns={columns} dataSource={this.state.dataSource} pagination={false}
                           onRow={(record) => {
                               return {
                                   onClick: (event) => {
                                       window.location.href="/content/"+record.user_character_id;
                                   },       // 点击行
                               };
                           }}
                    />
                </Modal>
            </div>
        );
    }
}

export default LoginForm
