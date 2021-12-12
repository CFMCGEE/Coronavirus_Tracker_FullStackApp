import { Navigate, Outlet } from "react-router-dom";

const ReRouterComponent = () => {

    const auth = null; 

    return auth ? <Outlet /> : <Navigate to="/information/covid-data" />;
    
}


export default ReRouterComponent;
