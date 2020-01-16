import axios from 'axios'

const state = {
    member : {},
    isAuth: '',

}
const getters = {
    getMember : state=>state.member,
    getIsAuth : state=>state.isAuth

}
const actions = {
    login({commit}, {context, id, pw}){
        alert(`${context},${id},${pw}` )
        let url = `${context}/login`
        let headers ={  'authorization': 'JWT fefege..',
            'Accept' : 'application/json',
            'Content-Type': 'application/json'}
        axios.post(url, {id,pw}, headers)
            .then(({data})=>{
                alert(data.isAuth.toString())
                commit('LOGIN' ,data)
            })
            .catch(()=>{
                alert('axios fail')

            })
    }
}
const mutations = {
    LOGIN(state, data){
        state.isAuth = data.isAuth
        state.member = data.member

    }
}
export default {
    name: 'login',
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}