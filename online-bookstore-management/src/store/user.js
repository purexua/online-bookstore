export default {
	namespaced:true,
	actions:{
	},
	mutations:{
		SAVEUSER(state,user){
			state.user = user
		},
		CHANGEPASSWORD(state,password){
			state.user.password = password
		},
		CHANGEINFO(state,user){
			state.user.realName = user.realName
			state.user.email = user.email
			state.user.address = user.address
			state.user.phoneNumber = user.phoneNumber
		},
	},
	state:{
		user:{
			userId:'',
			userName:'',
			password:'',
			realName:'',
			email:'',
			address:'',
			phoneNumber:'',
			balance:'',
		},
	},
	getters:{
		
	},
}