import axios from 'axios';

let url="http://localhost:10001";

function obtain_skill(userCharacterId) {
    let s_url=url+"/skill/"+userCharacterId;
    return axios.get(s_url).then(response=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

function obtain_weapon(userCharacterId) {
    let w_url=url+"/weapon/"+userCharacterId;
    return axios.get(w_url).then(response=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

function obtain_character_detail(userCharacterId) {
    let c_url=url+'/character/detail/'+userCharacterId;
    return axios.get(c_url).then(response=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

export const character_service={
    obtain_skill,obtain_weapon,obtain_character_detail
}
