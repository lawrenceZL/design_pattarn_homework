import React,{Component} from 'react';
import { Layout } from 'antd';
import Header from '../header/header';

const {
    Footer, Sider, Content,
} = Layout;

class Loader extends Component{
    constructor(){
        super();
    }

    render(){
        return (
                <Layout>
                    <Header>Header</Header>
                    <Content style={{height:window.innerHeight}}>
                        <div style={{position:'fixed',left:'50%',top:'20%',width:'400px',height:'400px',marginLeft:'-200px',backgroundColor:'blue'}}>
                            <div style={{float:'left',width:'33%',backgroundColor:'green'}}>

                            </div>
                            <div style={{float:'left',width:'33%',backgroundColor:'yellow'}}>

                            </div>
                            <div style={{float:'left',width:'33%',backgroundColor:'green'}}>

                            </div>
                        </div>
                    </Content>
                </Layout>

        )
    }
}

export default Loader;
