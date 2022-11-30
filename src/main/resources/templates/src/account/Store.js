
import Vue from "vue";
import Vuex from "vuex";
import vuexPersistence from "vuex-persist";

const vuexLocal=new vuexPersistence({
    storage:window.localStorage
})

Vue.use(Vuex);
const store= new Vuex.Store({
    state:{
        logon:false,
        userIdentity:null,
        authenticated:false
    },
    mutations: {
        authenticate(state){
            state.logon=true;
        },
        authenticated(state,identity){
            state.userIdentity=identity;
            state.authenticated=true;
            state.logon=false;
        },
        logout(state){
            state.userIdentity=null;
            state.authenticated=false;
        }
    },
    getters: {
        logon: state =>state.logon,
        account: state=>state.userIdentity,
        authenticated: state=>state.authenticated

    },
    plugins:[vuexLocal.plugin]
});

export default store;