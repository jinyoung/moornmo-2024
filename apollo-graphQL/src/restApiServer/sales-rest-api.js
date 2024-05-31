import {RESTDataSource} from 'apollo-datasource-rest';

class salesRestApi extends RESTDataSource {
    constructor() {
        super();
        // dev for Local
            this.baseURL = 'http://localhost:8082';
        // dev for IDE
            // this.baseURL = 'http://8082-ide-xxxxxxxxxx.kuberez.io'
        // prod
            // this.baseURL = 'https://sales:8080';
    }

    async getSales() {
        const data = await this.get('/sales', {})
        var value = this.stringToJson(data);
        // return retunVal
        return value._embedded.sales;
    }

    // GET
    async getSales(id) {
        const data = await this.get(`/sales/${id}`, {})
        var value = this.stringToJson(data);
        return value;
    }

    stringToJson(str){
        if(typeof str == 'string'){
            str = JSON.parse(str);
        }
        return str;
    }
}

export default salesRestApi;




