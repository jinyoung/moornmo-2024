
import {RESTDataSource} from 'apollo-datasource-rest';

class masterRestApi extends RESTDataSource {
    constructor() {
        super();
        // dev for Local
            this.baseURL = 'http://localhost:8085';
        // dev for IDE
            // this.baseURL = 'http://8085-ide-xxxxxxxxxx.kuberez.io'
        // prod
            // this.baseURL = 'https://master:8080';
    }

    async getCompanies() {
        const data = await this.get('/companies', {})
        var value = this.stringToJson(data);
        // return retunVal
        return value._embedded.companies;
    }

    // GET
    async getCompany(id) {
        const data = await this.get(`/companies/${id}`, {})
        var value = this.stringToJson(data);
        return value;
    }
    async getUsers() {
        const data = await this.get('/users', {})
        var value = this.stringToJson(data);
        // return retunVal
        return value._embedded.users;
    }

    // GET
    async getUser(id) {
        const data = await this.get(`/users/${id}`, {})
        var value = this.stringToJson(data);
        return value;
    }
    async getItems() {
        const data = await this.get('/items', {})
        var value = this.stringToJson(data);
        // return retunVal
        return value._embedded.items;
    }

    // GET
    async getItem(id) {
        console.log("id="+ id)

        const data = await this.get(`/items/${id}`, {})
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

export default masterRestApi;




