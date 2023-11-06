export default {
	namespaced:true,
	actions:{
	},
	mutations:{
		SAVEUSER(state,user){
			state.user = user
		}
	},
	state:{
		user:{
			username:'',
			password:'',
			balance:'',
		},
	},
	getters:{
		
	},
}