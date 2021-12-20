import React from 'react'
import {ReactComponent as COVIDAPILogo} from '../images/covidapi.svg'

import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import Link from '@mui/material/Link';

const FooterComponent = () => {

    return (
        <Box
          sx={{
            display: 'flex',
            flexDirection: 'column',
            minHeight: '22vh',
          }}
        >
          <CssBaseline />
          <Box
            component="footer"
            sx={{
              py: 3,
              px: 2, 
              mt: 'auto',
              backgroundColor: "#31347a"
            }}>
            <Container maxWidth="sm">
            <COVIDAPILogo className="footerSpace" />
            <Link color="#FFFFFF" href="https://covidactnow.org/data-api" target="_blank" rel="noreferrer noopener">
                Created using the Covid Act Now API.  
            </Link>
            </Container>
          </Box> 
        </Box>
      );
     
    // return (

    //     <div>

    //         <footer style={{ backgroundColor: "#31347a", color: "#FFFFFF" }} className ="footer"> 
    //                 <COVIDAPILogo style={{ width: "180px", height: "40px" }} />
    //             <a href="https://covidtracking.com/data/api" target="_blank" rel="noreferrer noopener">Created using The COVID Tracking Project API.</a>
    //         </footer>

    //     </div>
         
    // )

}

export default FooterComponent
