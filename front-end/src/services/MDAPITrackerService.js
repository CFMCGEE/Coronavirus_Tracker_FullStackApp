import axios from 'axios'

const MARYLAND_BASE_API = "http://localhost:8080/md/api/tracker";

class MDAPITrackerService { 

    getAllMarylandData() { 
        return axios.get(MARYLAND_BASE_API + "/all")
    }
    
}

export default new MDAPITrackerService();

