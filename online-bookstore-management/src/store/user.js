export default {
	namespaced: true,
	actions: {
	},
	mutations: {
		SAVEUSER(state, user) {
			state.user = user
		},
		CHANGEPASSWORD(state, password) {
			state.user.password = password
		},
		CHANGEINFO(state, user) {
			state.user.realName = user.realName
			state.user.email = user.email
			state.user.address = user.address
			state.user.phoneNumber = user.phoneNumber
		},
		CHANGEBALANCE(state, balance) {
			state.user.balance = state.user.balance + balance
		}
	},
	state: {
		user: {
			userId: '',
			userName: '',
			password: '',
			realName: '',
			email: '',
			address: '',
			phoneNumber: '',
			balance: '',
		},
	},
	getters: {

	},
}