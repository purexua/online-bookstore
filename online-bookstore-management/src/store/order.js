import axios from 'axios';

export default {
    namespaced: true,
    actions: {
        getOrderData(context, userId) {
            axios.get('http://localhost:3919/serve8080/order/page/id', {
                params: {
                    userId: userId,
                    pageNum: context.state.pageInfoOrder.pageNum,
                    pageSize: context.state.pageInfoOrder.pageSize,
                }
            })
                .then(response1 => {
                    axios.get('http://localhost:3919/serve8080/order/page/info/id', {
                        params: {
                            userId: userId,
                            pageNum: context.state.pageInfoOrder.pageNum,
                            pageSize: context.state.pageInfoOrder.pageSize,
                        }
                    })
                        .then(response2 => {
                            context.commit('GETORDERDATA', {
                                tableData: response1.data,
                                pageInfo: response2.data
                            });
                        })
                        .catch(error => {
                            console.error(error);
                        });
                })
                .catch(error => {
                    console.error(error);
                });
        },
        getOrderById(context, data) {
            //data = {  userId ,orderId }
            axios.get('http://localhost:3919/serve8080/order/id', {
                params: {
                    userId: data.userId,
                    orderId: data.orderId,
                }
            })
                .then(response1 => {
                    context.commit('GETORDERBYID', response1.data);
                })
                .catch(error => {
                    console.error(error);
                });
        },
        getOrderItemById(context, orderId) {
            //data = { orderId }
            axios.get('http://localhost:3919/serve8080/order/item/id', {
                params: {
                    orderId: orderId,
                }
            })
                .then(response1 => {
                    context.commit('GETORDERITEMBYID', response1.data);
                })
                .catch(error => {
                    console.error(error);
                });
        },
        insertOrder(context, data) {
            axios({
                method: 'post',
                url: 'http://localhost:3919/serve8080/order',
                params: {  // 使用 'data' 替代 'params' 用于 POST 请求
                    userId: data.userId,
                }
            }).then(response => {
                console.log('orderID=', response.data);
                context.commit('INSERTORDERID', response.data);
                console.log('context.state.insertOrderId orderID=', context.state.insertOrderId);

                for (let i = 0; i < data.multipleSelection.length; i++) {
                    const orderItem = {
                        orderId: context.state.insertOrderId,
                        bookId: data.multipleSelection[i].bookId,
                        quantity: data.multipleSelection[i].quantity
                    };
                    // 插入订单项
                    context.dispatch('insertOrderItem', orderItem);
                }

            }).catch(error => {
                console.error(error);
            });
        },
        insertOrderItem(context, data) {
            axios({
                method: 'post',
                url: 'http://localhost:3919/serve8080/order/item',
                params: {
                    orderId: data.orderId,
                    bookId: data.bookId,
                    quantity: data.quantity,
                }
            }).then(response => {
                console.log(response.data);
            }).catch(error => {
                console.error(error);
            });
        },
    },
    mutations: {
        GETORDERDATA(state, data) {
            state.order = data.tableData;
            state.pageInfoOrder = data.pageInfo;
        },
        GETORDERBYID(state, data) {
            state.orderById = data;
        },
        SETPAGENUM(state, data) {
            state.pageInfoOrder.pageNum = data;
        },
        GETORDERITEMBYID(state, data) {
            state.orderItemById = data;
        },
        INSERTORDERID(state, data) {
            state.insertOrderId = data;
        },
    },
    state: {
        order: [],
        orderById: {},
        pageInfoOrder: {
            totalpages: 0,
            totalItems: 0,
            pageNum: 1,
            pageSize: 9,
        },
        orderItemById: [],
        insertOrderId: 0,
    },
    getters: {},
};
