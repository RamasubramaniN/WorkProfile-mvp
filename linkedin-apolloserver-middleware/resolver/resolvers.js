const allResolvers = {
    Query: {
        user: (root, {id}, {dataSources}) => {
            console.log(id);
            return dataSources.employeeDatasource.getEmployeeById(id)
        }
    }
};
module.exports = {resolvers: allResolvers}