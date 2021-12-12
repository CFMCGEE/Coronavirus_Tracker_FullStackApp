import axios from 'axios'

const PENNSYLVANIA_BASE_API = "http://localhost:8080/pa/api/tracker";

class PAAPITrackerService { 

    getAllPennsylvaniaData() { 
        return axios.get(PENNSYLVANIA_BASE_API + "/all")
    }
    
}

export default new PAAPITrackerService();

