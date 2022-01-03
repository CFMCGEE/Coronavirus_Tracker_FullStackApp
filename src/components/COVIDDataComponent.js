import React, {useEffect, useState} from 'react';
import {Map, Marker, Popup, TileLayer} from "react-leaflet";
import DEAPITrackerService from '../services/DEAPITrackerService';
import MDAPITrackerService from '../services/MDAPITrackerService';
import PAAPITrackerService from '../services/PAAPITrackerService';
import YoutubeEmbed from "./YoutubeVideoComponent";
import Grid from '@mui/material/Grid';

// eslint-disable-next-line
import { Chart as ChartJS } from "chart.js/auto";
import {Line} from "react-chartjs-2";
import {ArcElement, Chart} from 'chart.js'

Chart.register(ArcElement);

const COVIDTrackerCompoent = () => {

    <link href="https://fonts.googleapis.com/css2?family=Inconsolata:wght@600&display=swap" rel="stylesheet" />

    const labels = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    const youtubeVideoIDS = ['xiS6c-eBNKA', 'rLY174n_KWA', '2KlzTEl8ATo', 'ZfdOltzpp3s', 'JWMkeMA3sfA', 'IA4UeltYUiw', 'Ug9xQ7LQnsw', '_JRWWJZEl_o', 'yc_LYdRyEAw', 'jUDL7VHN5yE']

    // const onMove = (e) => {
    //     console.log(e.target.getCenter());
    //   }

    const DElocation = [39.15005415636659, -75.50628662109376]
    const [delawareCases, setDelawareCases] = useState('');
    const [delawareDeaths, setDelawareDeaths] = useState('');
    const [delawarePositiveTests, setDelawarePositiveTests] = useState('');
    const [delawareNegativeTests, setDelawareNegativeTests] = useState('');
    const [delawareState, setDelawareState] = useState('');
    const [delawarePopulation, setDelawarePopulation] = useState(''); 

    const MDlocation = [38.81190259081752, -76.37419165220638]
    const [marylandCases, setMarylandCases] = useState('');
    const [marylandDeaths, setMarylandDeaths] = useState('');
    const [marylandPositiveTests, setMarylandPositiveTests] = useState('');
    const [marylandNegativeTests, setMarylandNegativeTests] = useState('');
    const [marylandState, setMarylandState] = useState('');
    const [marylandPopulation, setMarylandPopulation] = useState(''); 

    const PAlocation = [41.12492846680012, -77.68981933593751]
    const [pennsylvaniaCases, setPennsylvaniaCases] = useState(''); 
    const [pennsylvaniaDeaths, setPennsylvaniaDeaths] = useState('');
    const [pennsylvaniaPositiveTests, setPennsylvaniaPositiveTests] = useState('');
    const [pennsylvaniaNegativeTests, setPennsylvaniaNegativeTests] = useState('');
    const [pennsylvaniaState, setPennsylvaniaState] = useState('');
    const [pennsylvaniaPopulation, setPennsylvaniaPopulation] = useState('');

    const [youtubeID, setYoutubeID] = useState('IA4UeltYUiw');
             
      const getAllDelawareData = () => {
        
          DEAPITrackerService.getAllDelawareData().then((response) => {
  
              response.data.data[0].actuals.cases === 0 ? setDelawareCases(0) : setDelawareCases(response.data.data[0].actuals.cases)
              response.data.data[0].actuals.deaths === 0 ? setDelawareDeaths(0) : setDelawareDeaths(response.data.data[0].actuals.deaths)
              response.data.data[0].actuals.positiveTests === 0 ? setDelawarePositiveTests(0) : setDelawarePositiveTests(response.data.data[0].actuals.positiveTests)
              response.data.data[0].actuals.negativeTests === 0 ? setDelawareNegativeTests(0) : setDelawareNegativeTests(response.data.data[0].actuals.negativeTests)
              response.data.data[0].state === 0 ? setDelawareState(0) : setDelawareState(response.data.data[0].state)
              response.data.data[0].population === 0 ? setDelawarePopulation(0) : setDelawarePopulation(response.data.data[0].population)
             
              console.log(response.data.data[0])
  
          }).catch(error =>{
              console.log(error);
          })

      }

      const getAllMarylandData = () => {
        
        MDAPITrackerService.getAllMarylandData().then((response) => {

            response.data.data[0].actuals.cases === 0 ? setMarylandCases(0) : setMarylandCases(response.data.data[0].actuals.cases)
            response.data.data[0].actuals.deaths === 0 ? setMarylandDeaths(0) : setMarylandDeaths(response.data.data[0].actuals.deaths)
            response.data.data[0].actuals.positiveTests === 0 ? setMarylandPositiveTests(0) : setMarylandPositiveTests(response.data.data[0].actuals.positiveTests)
            response.data.data[0].actuals.negativeTests === 0 ? setMarylandNegativeTests(0) : setMarylandNegativeTests(response.data.data[0].actuals.negativeTests)
            response.data.data[0].state === 0 ? setMarylandState(0) : setMarylandState(response.data.data[0].state)
            response.data.data[0].population === 0 ? setMarylandPopulation(0) : setMarylandPopulation(response.data.data[0].population)

            console.log(response.data.data[0])

        }).catch(error =>{
            console.log(error);
        })

    }

      const getAllPennsylvaniadData = () => {
        
        PAAPITrackerService.getAllPennsylvaniaData().then((response) => {

            response.data.data[0].actuals.cases === 0 ? setPennsylvaniaCases(0) : setPennsylvaniaCases(response.data.data[0].actuals.cases)
            response.data.data[0].actuals.deaths === 0 ? setPennsylvaniaDeaths(0) : setPennsylvaniaDeaths(response.data.data[0].actuals.deaths)
            response.data.data[0].actuals.positiveTests === 0 ? setPennsylvaniaPositiveTests(0) : setPennsylvaniaPositiveTests(response.data.data[0].actuals.positiveTests)
            response.data.data[0].actuals.negativeTests === 0 ? setPennsylvaniaNegativeTests(0) : setPennsylvaniaNegativeTests(response.data.data[0].actuals.negativeTests)
            response.data.data[0].state === 0 ? setPennsylvaniaState(0) : setPennsylvaniaState(response.data.data[0].state)
            response.data.data[0].population === 0 ? setPennsylvaniaPopulation(0) : setPennsylvaniaPopulation(response.data.data[0].population)

            console.log(response.data.data[0])

        }).catch(error =>{
            console.log(error);
        })

      }

    useEffect(() => {

        getAllDelawareData();
        getAllMarylandData();
        getAllPennsylvaniadData();

        setInterval(() => {

            const randomYTID = youtubeVideoIDS[Math.floor(Math.random() * youtubeVideoIDS.length)];

            setYoutubeID(randomYTID);

            console.log(`Watch the randomly picked video on YouTube: https://www.youtube.com/watch?v=${randomYTID}`);

        }, 10000);

        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

      return (

        <div>
         <div className="video-positioner">
        {<YoutubeEmbed embedId={youtubeID} />}
        </div>
        <Grid style={{ marginTop: "30px", marginLeft: "150px" }} container spacing={0}>
        <Grid item sm>
        <div className={["data_chart_background_with_container"]}>
          <Line 
          data={{
              labels: labels,
              datasets: [
                {
                  label: "COVID Cases",
                  data: [78071, 86799, 94802, 104405, 108866, 109744, 111407, 119852, 132963, 144198, 153190, delawareCases],
                  backgroundColor: '#00ffec',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
                {
                  label: "Deaths",
                  data: [1090, 1422, 1559, 1625, 1661, 1694, 1833, 1880, 1954, 2091, 2178, delawareDeaths],
                  backgroundColor: '#FFFFFF',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
                {
                  label: "Positive Tests",
                  data: [95167, 104769, 112624, 122132, 125776, 126654, 128510, 137500, 151629, 163577, 174466, delawarePositiveTests],
                  backgroundColor: '#e200ff',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
                {
                  label: "Negative Tests",
                  data: [1352142, 1524792, 1704058, 1868076, 1980071, 2049923, 2113001, 2234944, 2405101, 2573986, 2726697, delawareNegativeTests],
                  backgroundColor: '#ff0000',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
              ],
            }}
            height={400}
            width={600}
            options={{
              maintainAspectRatio: false,
              color: "#000000",
              responsive: true,
              plugins: {
                legend: {
                  position: 'top',
                },
                title: {
                  display: true,
                  text: `Delaware's COVID Data`,
                  color: 'black',
                  font: {
                    size: 19,
                    family: 'Inconsolata',
                    weight: 'normal'
                  },
                },
                  subtitle: {
                    display: true,
                    text: 'January 2021 - December 2021',
                    color: 'black',
                    font: {
                      size: 15,
                      family: 'Roboto',
                      weight: 'normal',
                      style: 'italic'
                    },
                    padding: {
                      bottom: 10
                    }
                }
              }
            }}
          />
          </div>
          </Grid>
          <Grid item sm style={{ marginTop: "-75px" }}>
         <Map 
      
      className="lea-container"
      center={DElocation}
      zoom={8}
      minZoom={8}
      maxZoom={10}
      zoomControl={false}
      // onMoveEnd={onMove.bind(this)}
      dragging={false} 
      scrollWheelZoom={false}
      doubleClickZoom={false}

      >
        <TileLayer
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        />
  
      <Marker position={DElocation} draggable={false}>
        <Popup>{delawareState}, Population: {delawarePopulation}</Popup>
      </Marker>
  
      </Map>
      </Grid> 
      </Grid>
      <br /> <br /> <br /> <br />
          <Grid style={{ marginTop: "30px", marginLeft: "150px" }} container spacing={0}>
          <Grid item sm>
          <div className={["data_chart_background_with_container"]}>
          <Line 
          data={{
              labels: labels,
              datasets: [
                {
                  label: "COVID Cases",
                  data: [354649, 382281, 411529, 447590, 460106, 462496, 468767, 497225, 532570, 561501, 586376, marylandCases],
                  backgroundColor: '#00ffec',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
                {
                  label: "Deaths",
                  data: [7127, 7869, 8286, 8744, 9614, 9741, 9825, 10014, 10442, 10895, 11206, marylandDeaths],
                  backgroundColor: '#FFFFFF',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
                {
                  label: "Positive Tests",
                  data: [717454, 780852, 846685, 926590, 953832, 959243, 973645, 1038170, 1112569, 1177224, 1231149, marylandPositiveTests],
                  backgroundColor: '#e200ff',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
                {
                  label: "Negative Tests",
                  data: [6858161, 7747726, 8644722, 9560444, 10235884, 10702924, 11149591, 11896811, 12818801, 13885503, 14829361, marylandNegativeTests],
                  backgroundColor: '#ff0000',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
              ],
            }}
            height={400}
            width={600}
            options={{
              maintainAspectRatio: false,
              color: "#000000",
              responsive: true,
              plugins: {
                legend: {
                  position: 'top',
                },
                title: {
                  display: true,
                  text: `Maryland's COVID Data`,
                  color: 'black',
                  font: {
                    size: 19,
                    family: 'Inconsolata',
                    weight: 'normal'
                  },
                },
                  subtitle: {
                    display: true,
                    text: 'January 2021 - December 2021',
                    color: 'black',
                    font: {
                      size: 15,
                      family: 'Roboto',
                      weight: 'normal',
                      style: 'italic'
                    },
                    padding: {
                      bottom: 10
                    }
                }
              }
            }}
          />
          </div>
          </Grid>
          <Grid item sm style={{ marginTop: "-75px" }}>
        <Map 
      
      className="lea-container"
      center={MDlocation}
      zoom={8}
      minZoom={8}
      maxZoom={10}
      zoomControl={false}
      // onMoveEnd={onMove.bind(this)}
      dragging={false} 
      scrollWheelZoom={false}
      doubleClickZoom={false}

      >
        <TileLayer
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        />
  
      <Marker position={MDlocation} draggable={false}>
        <Popup>{marylandState}, Population: {marylandPopulation}</Popup>
      </Marker>
  
      </Map>
          </Grid>
          </Grid>
          <br /> <br /> <br /> <br />
          <Grid style={{ marginTop: "30px", marginLeft: "150px" }} container spacing={0}>
            <Grid item sm>
          <div className={["data_chart_background_with_container"]}>
          <Line 
          data={{
              labels: labels,
              datasets: [
                {
                  label: "COVID Cases",
                  data: [848244, 935911, 1030415, 1156246, 1206755, 1216579, 1229002, 1300368, 1429940, 1564939, 1736920, pennsylvaniaCases],
                  backgroundColor: '#00ffec',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
                {
                  label: "Deaths",
                  data: [21715, 24056, 25150, 26275, 27268, 27725, 27850, 28235, 29400, 31454, 33421, pennsylvaniaDeaths],
                  backgroundColor: '#FFFFFF',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
                {
                  label: "Positive Tests",
                  data: [926333, 1000855, 1085238, 1198043, 1241042, 1249630, 1262310, 1330072, 1456411, 1577256, 1724692, pennsylvaniaPositiveTests],
                  backgroundColor: '#e200ff',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
                {
                  label: "Negative Tests",
                  data: [9119774, 10234694, 11442305, 12731217, 13606778, 14169499, 14634348, 15531420, 16836021, 18056481, 19190666, pennsylvaniaNegativeTests],
                  backgroundColor: '#ff0000',
                  borderColor: '#000000',
                  borderWidth: 1,
                },
              ],
            }}
            height={400}
            width={600}
            options={{
              maintainAspectRatio: false,
              color: "#000000",
              responsive: true,
              plugins: {
                legend: {
                  position: 'top',
                },
                title: {
                  display: true,
                  text: `Pennsylvania's COVID Data`,
                  color: 'black',
                  font: {
                    size: 19,
                    family: 'Inconsolata',
                    weight: 'normal'
                  },
                },
                  subtitle: {
                    display: true,
                    text: 'January 2021 - December 2021',
                    color: 'black',
                    font: {
                      size: 15,
                      family: 'Roboto',
                      weight: 'normal',
                      style: 'italic'
                    },
                    padding: {
                      bottom: 10
                    }
                }
              }
            }}
          />
          </div>
          </Grid>
          <Grid item sm style={{ marginTop: "-75px" }}>
         <Map 
      
      className="lea-container"
      center={PAlocation}
      zoom={7}
      minZoom={7}
      maxZoom={10}
      zoomControl={false}
      // onMoveEnd={onMove.bind(this)}
      dragging={false} 
      scrollWheelZoom={false}
      doubleClickZoom={false}
 
      >
        <TileLayer
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        />
  
      <Marker position={PAlocation} draggable={false}>
        <Popup>{pennsylvaniaState}, Population: {pennsylvaniaPopulation}</Popup>
      </Marker>
  
      </Map>
      </Grid>
      </Grid>
     </div>
  )

}

export default COVIDTrackerCompoent;