import React,{Component} from 'react';
import {Tooltip} from 'antd'
import skill_1_2 from "../../meterials/image/skill_1_2.png";
import skill_2_2 from "../../meterials/image/skill_2_2.png";
import skill_3_2 from "../../meterials/image/skill_3_2.png";
import skill_1_1 from "../../meterials/image/skill_1_1.png";
import skill_2_1 from "../../meterials/image/skill_2_1.png";
import skill_3_1 from "../../meterials/image/skill_3_1.png";
import skill_1_3 from "../../meterials/image/skill_1_3.png";
import skill_2_3 from "../../meterials/image/skill_2_3.png";
import skill_3_3 from "../../meterials/image/skill_3_3.png";
import skill_1_4 from "../../meterials/image/skill_1_4.png";
import skill_2_4 from "../../meterials/image/skill_2_4.png";
import skill_3_4 from "../../meterials/image/skill_3_4.png";

class Skill extends Component{
    constructor(props){
        super(props);
        this.state={
            skill_data:props.skill_data,
        }
    }


    render(){
        console.log(this.state.skill_data)
        return(
            <div style={{width:'100%',height:'118px'}}>
                <div style={{width:'118px',height:'118px',float:'left',padding:'10px'}}>
                    {this.state.skill_data[0].skillId===1&&
                        <Tooltip title={this.state.skill_data[0].name}>
                    <img className={this.state.skill_1_use} src={skill_1_1} width="100%" height="100%"/>
                        </Tooltip>
                    }
                    {this.state.skill_data[0].skillId===5&&
                    <Tooltip title={this.state.skill_data[0].name}>
                    <img className={this.state.skill_1_use} src={skill_2_1} width="100%" height="100%"/>
                    </Tooltip>
                    }
                    {this.state.skill_data[0].skillId===9&&
                    <Tooltip title={this.state.skill_data[0].name}>
                    <img className={this.state.skill_1_use} src={skill_3_1} width="100%" height="100%"/>
                    </Tooltip>
                    }
                </div>
                <div style={{width:'118px',height:'118px',float:'left',padding:'10px'}}>
                    {this.state.skill_data[1].skillId===2&&
                    <Tooltip title={this.state.skill_data[1].name}>
                    <img className={this.state.skill_2_use} src={skill_1_2} width="100%" height="100%"/>
                    </Tooltip>
                    }
                    {this.state.skill_data[1].skillId===6&&
                    <Tooltip title={this.state.skill_data[1].name}>
                    <img className={this.state.skill_2_use} src={skill_2_2} width="100%" height="100%"/>
                    </Tooltip>
                    }
                    {this.state.skill_data[1].skillId===10&&
                    <Tooltip title={this.state.skill_data[1].name}>
                    <img className={this.state.skill_2_use} src={skill_3_2} width="100%" height="100%"/>
                    </Tooltip>
                    }
                </div>
                <div style={{width:'118px',height:'118px',float:'left',padding:'10px'}}>
                    {this.state.skill_data[2].skillId===3&&
                    <Tooltip title={this.state.skill_data[2].name}>
                    <img className={this.state.skill_3_use} src={skill_1_3} width="100%" height="100%"/>
                    </Tooltip>
                    }
                    {this.state.skill_data[2].skillId===7&&
                    <Tooltip title={this.state.skill_data[2].name}>
                    <img className={this.state.skill_3_use} src={skill_2_3} width="100%" height="100%"/>
                    </Tooltip>
                    }
                    {this.state.skill_data[2].skillId===11&&
                    <Tooltip title={this.state.skill_data[2].name}>
                    <img className={this.state.skill_3_use} src={skill_3_3} width="100%" height="100%"/>
                    </Tooltip>
                    }
                </div>
                <div style={{width:'118px',height:'118px',float:'left',padding:'10px'}}>
                    {this.state.skill_data[3].skillId===4&&
                    <Tooltip title={this.state.skill_data[3].name}>
                    <img className={this.state.skill_4_use} src={skill_1_4} width="100%" height="100%"/>
                    </Tooltip>
                    }
                    {this.state.skill_data[3].skillId===8&&
                    <Tooltip title={this.state.skill_data[3].name}>
                    <img className={this.state.skill_4_use} src={skill_2_4} width="100%" height="100%"/>
                    </Tooltip>
                    }
                    {this.state.skill_data[3].skillId===12&&
                    <Tooltip title={this.state.skill_data[3].name}>
                    <img className={this.state.skill_4_use} src={skill_3_4} width="100%" height="100%"/>
                    </Tooltip>
                    }
                </div>
            </div>
        )
    }
}

export default Skill;
