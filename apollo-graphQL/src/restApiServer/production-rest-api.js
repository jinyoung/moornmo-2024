import {RESTDataSource} from 'apollo-datasource-rest';

class productionRestApi extends RESTDataSource {
    constructor() {
        super();
        // dev for Local
            this.baseURL = 'http://localhost:8083';
        // dev for IDE
            // this.baseURL = 'http://8083-ide-xxxxxxxxxx.kuberez.io'
        // prod
            // this.baseURL = 'https://production:8080';
    }

    async getProductions() {
        const data = await this.get('/productions', {})
        var value = this.stringToJson(data);
        // return retunVal
        return value._embedded.productions;
    }

    // GET
    async getProduction(id) {
        const data = await this.get(`/productions/${id}`, {})
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

export default productionRestApi;




