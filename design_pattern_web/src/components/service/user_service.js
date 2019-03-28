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

export const user_service={
    register,login,
}
