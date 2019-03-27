import React,{Component} from 'react';
import {Menu} from 'antd';
import './ant_mydefine.css'


class GHeader extends Component {
    constructor(props) {
        super(props);
        this.state = {
            current: 'none',
        }
    }



    render() {
        return <div className="header" style={{height:`64px`}}>
            <div className="logo"></div>
            <Menu theme="dark" mode="horizontal" style={{lineHeight: '64px'}}>
                <Menu.Item>设计模式</Menu.Item>
                <Menu.Item>战斗成长游戏</Menu.Item>
            </Menu>
        </div>
    }
}

export default GHeader

