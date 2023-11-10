import axios from 'axios';

export default {
    namespaced: true,
    actions: {       
        getShoppingCart(context, userId) {
            axios({
                method: 'get',
                url: 'http://localhost:3919/serve8080/shopping/cart',
                params: {
                    userId: userId
                }
            }).then((response) => {
                context.commit('GETSHOPPINGCART', response.data)
            }).catch((error) => {
                console.error(error);
            })
        },
        getShoppingCartItems(context, cartId) {
            axios({
                method: 'get',
                url: 'http://localhost:3919/serve8080/shopping/cart/items',
                params: {
                    cartId: cartId
                }
            }).then((response) => {
                context.commit('GETSHOPPINGCARTITEMS', response.data)
            }).catch((error) => {
                console.error(error);
            })
        },
        add(context, data) {
            axios({
                method: 'post',
                url: 'http://localhost:3919/serve8080/shopping/cart/item/add',
                params: {
                    cartId: data.cartId,
                    bookId: data.bookId,
                    quantity: data.quantity,
                }
            }).then((response) => {
                context.dispatch('getShoppingCartItems', data.cartId);
            }).catch((error) => {
                console.error(error);
            })
        },
    },
    mutations: {
        GETSHOPPINGCART(state, data) {
            state.shoppingCart = data;
        },
        GETSHOPPINGCARTITEMS(state, data) {
            state.shoppingCartItems = data;
        }
    },
    state: {
        shoppingCart: {},
        shoppingCartItems: [],
    },
    getters: {

    },
}