import React from 'react'
import {Route} from 'react-router-dom'
import LoginForm from "../login/login_form";
import Register from "../register/register";
import Content from '../content/content';
import Loader from "../content/loader";


const Page = () => (
    <div>
        <Route exact path="/" render={() => (<LoginForm/>)}/>
        <Route exact path="/login" render={() => (<LoginForm/>)}/>
        <Route exact path="/register" render={()=>(<Register/>)}/>
        <Route exact path="/content" render={()=>(<Content/>)}/>
        <Route exact path='/loader' render={()=>(<Loader/>)}/>
    </div>
)

export default Page
