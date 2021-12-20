import axios from 'axios'

const DELAWARE_BASE_API = "http://localhost:8080/de/api/tracker";

class DEAPITrackerService { 

    getAllDelawareData() { 
        return axios.get(DELAWARE_BASE_API + "/all")
    }
    
}

export default new DEAPITrackerService();

