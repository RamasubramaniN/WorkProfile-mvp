const { RESTDataSource } = require('apollo-datasource-rest');

class EmployeeDatasource extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = "http://localhost:8080/linkedin/";
    }

    async getEmployeeById(id) {
        return this.get(`users/${id}`);
    }
}
module.exports = EmployeeDatasource;