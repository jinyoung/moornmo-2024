
import {gql} from 'apollo-server';

const typeDefs = gql`
    scalar Date
    scalar Long
    scalar Double
    scalar Integer

    type Sales {
    	id: Long! 
			qty: Integer 
			status: String 
			companyId: CompanyId 
      company: Company
			itemId: ItemId
      item: Item
    }
    type Production {
    	id: Long! 
			productId: String 
			qty: Integer 
			orderId: Long
    }
    type CompanyId {
    	id: String! 
			name: String 
    }
    type ItemId {
    	id: String! 
			name: String 
    }
    type Company {
    	id: String! 
			name: String 
			addresses: [Address]
    }
    type User {
    	id: String! 
			email: String 
			name: String 
			addresses: [Address]
    }
    type Item {
    	id: String! 
			name: String
    }
    type Address {
    	city: String! 
			street: String
    }


    type Query {
      sales: [Sales]
      sale(id: Long!): Sales
      productions: [Production]
      production(id: Long!): Production
      companies: [Company]
      company(id: Long!): Company
      users: [User]
      user(id: Long!): User
      items: [Item]
      item(id: Long!): Item
    }
`;

export default typeDefs;


