import React,{Component} from 'react';
import { Layout } from 'antd';
import Header from '../header/header';

const {
     Footer, Sider, Content,
} = Layout;

class PContent extends Component{
    constructor(){
        super();
    }

    render(){
        return (
            <div>
                <Layout>
                    <Header>Header</Header>
                    <Content>Content</Content>
                    <Footer>Footer</Footer>
                </Layout>
            </div>
        )
    }
}

export default PContent;
