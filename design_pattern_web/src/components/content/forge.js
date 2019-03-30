import React,{Component} from 'react';
import forge from '../../meterials/image/forge_2.png'
import {Tooltip} from 'antd';

class Forge extends Component{
    constructor(props){
        super(props);
    }

    render(){
        return(
            <div>
                <Tooltip title="锻造炉">
                <img src={forge} style={{width:'472px'}}/>
                </Tooltip>
            </div>
        )
    }
}

export default Forge;
