import axios from 'axios';

const FLIGHT_API_BASE_URL = "";

class FlightController {
    getEmployees(){
        return axios.get();
    }

    createEmployee(employee){
        return axios.post();
    }

    getEmployeeById(employeeId){
        return axios.get();
    }

    updateEmployee(employee, employeeId){
        return axios.put();
    }

    deleteEmployee(employeeId){
        return axios.delete();
    }
}

export default new FlightController()

