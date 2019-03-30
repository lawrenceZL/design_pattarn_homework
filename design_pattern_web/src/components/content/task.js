import React,{Component} from 'react';
import { List, Typography } from 'antd';

const data = [
    '连续七天登录游戏',
    '成功击杀20个小怪',
    '成功获得完整的六件装备',
    '人物角色升到20级',
    '武器升到10级',
];
class Task extends Component{
    constructor(props){
        super(props);
    }

    render(){
        return(
            <div>
                <List
                    header={<div>任务清单</div>}
                    bordered
                    dataSource={data}
                    renderItem={item => (<List.Item><Typography.Text mark>[ITEM]</Typography.Text> {item}</List.Item>)}
                />

            </div>
        )
    }
}

export default Task;
