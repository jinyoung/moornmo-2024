const resolvers = {
    Sales: {
        // set Query
    }
    Production: {
        // set Query
    }
    Company: {
        // set Query
    }
    User: {
        // set Query
    }
    Item: {
        // set Query
    }

    Query: {
        sales : async (_, { id }, { dataSources }) => {
            return dataSources.salesRestApi.getSales(id);
        },
        sales : async (_, __, { dataSources }) => {
            return dataSources.salesRestApi.getSales();
        },
        production : async (_, { id }, { dataSources }) => {
            return dataSources.productionRestApi.getProduction(id);
        },
        productions : async (_, __, { dataSources }) => {
            return dataSources.productionRestApi.getProductions();
        },
        company : async (_, { id }, { dataSources }) => {
            return dataSources.masterRestApi.getCompany(id);
        },
        companies : async (_, __, { dataSources }) => {
            return dataSources.masterRestApi.getCompanies();
        },
        user : async (_, { id }, { dataSources }) => {
            return dataSources.masterRestApi.getUser(id);
        },
        users : async (_, __, { dataSources }) => {
            return dataSources.masterRestApi.getUsers();
        },
        item : async (_, { id }, { dataSources }) => {
            return dataSources.masterRestApi.getItem(id);
        },
        items : async (_, __, { dataSources }) => {
            return dataSources.masterRestApi.getItems();
        },
    }
};

export default resolvers;

