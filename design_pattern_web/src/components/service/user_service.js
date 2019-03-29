import axios from 'axios'

let url="http://localhost:10001"
//注册
function register(username,password,sex,mail,tel) {
    let r_url=url+"/account/register";
    // let formData=new FormData();
    // formData.append("username",username);
    // formData.append("password",password);
    // formData.append("sex",sex);
    // formData.append("mail",mail);
    // formData.append("tel",tel);
    let json={};
    json["username"]=username;
    json["password"]=password;
    json["sex"]=sex;
    json["mail"]=mail;
    json["tel"]=tel;
    return axios.post(r_url,json).then((response)=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

//登录
function login(username,password) {
    let l_url=url+"/account/login";
    // let formData=new FormData();
    // formData.append("username",username);
    // formData.append("password",password);
    let json={};
    json["username"]=username;
    json["password"]=password;
    return axios.post(l_url,json).then((response)=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

//获取角色列表
function obtain_character_list() {
    let list_url=url+"/character/list";
    return axios.get(list_url).then((response)=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

//获取存档列表
function obtain_game_list(userId) {
    let g_list_url=url+"/character/monentos/"+userId;
    return axios.get(g_list_url).then(response=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

//创建角色
function bind_character(userId,characterId,nickname) {
    let b_url=url+"/character/bind";
    let json={};
    json["userId"]=userId;
    json["characterId"]=characterId;
    json["nickname"]=nickname;
    return axios.post(b_url,json).then((response)=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

export const user_service={
    register,login,obtain_character_list,obtain_game_list,bind_character
}
