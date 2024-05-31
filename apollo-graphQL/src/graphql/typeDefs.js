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
			itemId: ItemId
    }
    type Production {
    	id: Long! 
			productId: String 
			qty: Integer 
			orderId: Long
    }
    type Company {
    	id: Long! 
			name: String
    }
    type User {
    	id: Long! 
			email: String 
			name: String 
			addresses: List<Address> 
			title: Title
    }
    type Item {
    	id: Long! 
			name: String
    }

    type Query {
      sales: [Sales]
      sales(id: Long!): Sales
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


