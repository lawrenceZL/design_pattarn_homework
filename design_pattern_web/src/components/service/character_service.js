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

function obtain_character_info(userCharacterId) {
    let i_url=url+'/character/info/'+userCharacterId;
    return axios.get(i_url).then(response=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

function obtain_equip(userCharacterId,equiped) {
    let e_rrl=url+"/equip?userCharacterId="+userCharacterId+"&equiped="+equiped;
    return axios.get(e_rrl).then(response=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

function things_drop() {
    let drop_url=url+'/character/drop';
    return axios.post(drop_url,{}).then(response=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

function things_pick(userCharacterId,weaponCoupon,equipmentCoupon,equipments) {
    let pick_url=url+"/character/pick";
    let json={};
    json['userCharacterId']=userCharacterId;
    json['weaponCoupon']=weaponCoupon;
    json['equipmentCoupon']=equipmentCoupon;
    json['equipments']=equipments;
    return axios.post(pick_url,json).then(response=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

function create_monster(userCharacterId) {
    let c_m_url=url+'/character/goblin/'+userCharacterId;
    return axios.get(c_m_url).then(response=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

function attack(flag,goblin,userCharacterId,skillId,type) {
    let attack_url=url+'/attack';
    let json={};
    json['flag']=flag;
    json['goblin']=goblin;
    json['userCharacterId']=userCharacterId;
    json['skillId']=skillId;
    json['type']=type;
    return axios.post(attack_url,json).then(response=>{
        return response.data;
    }).catch({
        responseCode: 'RESPONSE_ERROR', description: 'Fail to process the request'
    })
}

export const character_service={
    obtain_skill,obtain_weapon,obtain_character_detail,obtain_character_info,
    obtain_equip,things_drop,attack,create_monster,things_pick
}
