
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import SalesSalesManager from "./components/listers/SalesSalesCards"
import SalesSalesDetail from "./components/listers/SalesSalesDetail"

import ProductionProductionManager from "./components/listers/ProductionProductionCards"
import ProductionProductionDetail from "./components/listers/ProductionProductionDetail"


import MasterCompanyManager from "./components/listers/MasterCompanyCards"
import MasterCompanyDetail from "./components/listers/MasterCompanyDetail"
import MasterUserManager from "./components/listers/MasterUserCards"
import MasterUserDetail from "./components/listers/MasterUserDetail"
import MasterItemManager from "./components/listers/MasterItemCards"
import MasterItemDetail from "./components/listers/MasterItemDetail"


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


            {
                path: '/masters/companies',
                name: 'MasterCompanyManager',
                component: MasterCompanyManager
            },
            {
                path: '/masters/companies/:id',
                name: 'MasterCompanyDetail',
                component: MasterCompanyDetail
            },
            {
                path: '/masters/users',
                name: 'MasterUserManager',
                component: MasterUserManager
            },
            {
                path: '/masters/users/:id',
                name: 'MasterUserDetail',
                component: MasterUserDetail
            },
            {
                path: '/masters/items',
                name: 'MasterItemManager',
                component: MasterItemManager
            },
            {
                path: '/masters/items/:id',
                name: 'MasterItemDetail',
                component: MasterItemDetail
            },



    ]
})
