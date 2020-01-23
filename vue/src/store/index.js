import Vue from 'vue'
import Vuex from 'vuex'
import cmm from "./cmm/cmm"
import user from './user/user'
import snsPage from './social/snsPage'
import snsDetail from './social/snsDetail'
import snsModify from './social/snsModify'

Vue.use(Vuex)

export const store = new Vuex.Store({
    modules: {
        cmm,
        user,
        snsPage,
        snsDetail,
        snsModify
    },
    strict: true
})