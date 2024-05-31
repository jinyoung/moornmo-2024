
const resolvers = {
    Sales: {
        company: async (root, {}, {dataSources}) => {
            return await dataSources.masterRestApi.getCompany(root.companyId.id);
        },
        item: async (root, {}, {dataSources}) => {
            return await dataSources.masterRestApi.getItem(root.itemId.id);
        }
    },
    Production: {
        // set Query
    },
    Company: {
        // set Query
    },
    User: {
        // set Query
    },
    Item: {
        // set Query
    },

    Query: {
        sale : async (_, { id }, { dataSources }) => {
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

