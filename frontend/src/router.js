
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import SalesSalesManager from "./components/listers/SalesSalesCards"
import SalesSalesDetail from "./components/listers/SalesSalesDetail"

import ProductionProductionManager from "./components/listers/ProductionProductionCards"
import ProductionProductionDetail from "./components/listers/ProductionProductionDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/sales/sales',
                name: 'SalesSalesManager',
                component: SalesSalesManager
            },
            {
                path: '/sales/sales/:id',
                name: 'SalesSalesDetail',
                component: SalesSalesDetail
            },

            {
                path: '/productions/productions',
                name: 'ProductionProductionManager',
                component: ProductionProductionManager
            },
            {
                path: '/productions/productions/:id',
                name: 'ProductionProductionDetail',
                component: ProductionProductionDetail
            },



    ]
})
