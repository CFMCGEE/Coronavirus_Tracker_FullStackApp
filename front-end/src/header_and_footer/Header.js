import React from 'react';
import { Navbar, Container, Nav } from 'react-bootstrap';
import {ReactComponent as COVIDAPILogo} from '../images/covidapi.svg'

const HeaderComponent = () => {

    return (
  
      <Navbar className="backgroundTab">
        <COVIDAPILogo style={{ width: "180px", height: "40px" }} />
      <Container>
      <Nav className={["me-auto", "backgroundTab"]}>
        <Nav.Link style={{ marginLeft: "27.5rem", color: "#FFFFFF", fontSize: "100%" }} href="https://covidactnow.org/?s=26601560" target="_blank" rel="noreferrer noopener">COVID Data from the Tri-State Area of Delaware, Maryland, and Pennsylvania</Nav.Link>
      </Nav>
      </Container> 
     </Navbar>

    );
    
};

export default HeaderComponent;
