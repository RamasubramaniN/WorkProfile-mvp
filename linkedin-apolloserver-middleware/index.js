const { ApolloServer } = require('apollo-server');
const { importSchema } = require('graphql-import');
const EmployeeDatasource = require ('./datasource/employee-datasource');
const typeDefs = importSchema('./schema/user.graphql');
const {resolvers} = require('./resolver/resolvers');

const server = new ApolloServer
    ({
        typeDefs,
        resolvers,
        dataSources: () =>({
        employeeDatasource: new EmployeeDatasource()
    })});

// The `listen` method launches a web server.
server.timeout = 0;
server.listen('9000').then(({ url }) => {
    console.log(`🚀  Server ready at ${url}`);
});