import {ApolloServer} from 'apollo-server';
import resolvers from './graphql/resolvers.js';
import typeDefs from './graphql/typeDefs.js';
import salesRestApi from './restApiServer/sales-rest-api.js'
import productionRestApi from './restApiServer/production-rest-api.js'
import dashboardRestApi from './restApiServer/dashboard-rest-api.js'
import masterRestApi from './restApiServer/master-rest-api.js'

const server = new ApolloServer({
    typeDefs,
    resolvers,
    dataSources: () => ({
        salesRestApi: new salesRestApi(),
        productionRestApi: new productionRestApi(),
        dashboardRestApi: new dashboardRestApi(),
        masterRestApi: new masterRestApi(),
    }),
});

server.listen({
    port: 8089,
}).then(({url}) => {
    console.log(`🚀  Server ready at ${url}`);
});
