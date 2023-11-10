import axios from 'axios'

export default {
	namespaced: true,
	actions: {
		pay(context, data) {
			axios({
				method: 'put',
				url: 'http://localhost:3919/serve8080/user/pay',
				params: {
					userId: data.userId,
					balance: data.money,
				}
			}).then((response) => {
				context.commit('CHANGEBALANCE', data.money)
			}).catch((error) => {
				console.error(error);
			})
		},
		updateUser(context, userId) {
			axios({
				method: 'get',
				url: 'http://localhost:3919/serve8080/user/id',
				params: {
					userId: userId
				}
			}).then((response) => {
				context.commit('SAVEUSER', response.data)
			}).catch((error) => {
				console.error(error);
			})
		},
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
		},
		PAY(state, money) {
			state.user.balance = state.user.balance - money
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