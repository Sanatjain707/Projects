



var latitudeVal;
var longitudeVal;
function getCoodinate() {

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        conlose.console.log("Error");
    }
}
function showPosition(data) {
    console.log("Latitude = "+data.coords.latitude + ", Longitude = "+ data.coords.longitude);
    latitudeVal = data.coords.latitude;
    longitudeVal = data.coords.longitude;
    getLocationByCoodinate();
}


async function getLocationByCoodinate() {
    const url = 'https://geocoding-by-api-ninjas.p.rapidapi.com/v1/reversegeocoding?lat=' + latitudeVal + '&lon=' + longitudeVal;
    const options = {
        method: 'GET',
        headers: {
            'X-RapidAPI-Key': 'eb15e677cdmshd20fec17dca3d04p12b12ajsn68f7f2908015',
            'X-RapidAPI-Host': 'geocoding-by-api-ninjas.p.rapidapi.com'
        }
    };

    try {
        const response = await fetch(url, options);
        const result = await response.text();
        console.log(result);
        const LocationName = JSON.parse(result);
        document.getElementById("cityName").value=LocationName[0].name;
        alert("If you get your location wrong then please add it manually for getting better results.");   
    } catch (error) {
        console.error(error);
    }
}

async function getWeather() {
    var city = document.getElementById("cityName").value;
    const url = 'https://weather-by-api-ninjas.p.rapidapi.com/v1/weather?city='+city;
    const options = {
        method: 'GET',
        headers: {
            'X-RapidAPI-Key': 'eb15e677cdmshd20fec17dca3d04p12b12ajsn68f7f2908015',
            'X-RapidAPI-Host': 'weather-by-api-ninjas.p.rapidapi.com'
        }
    };

    try {
        const response = await fetch(url, options);
        const result = await response.text();
        console.log(result);
        var res = JSON.parse(result);
        document.getElementById("YourLocation").innerHTML="Your Locaiton is :- "+city;
        document.getElementById("temp").value=res.temp;
        document.getElementById("humidity").value=res.humidity;
        
    } catch (error) {
        console.error(error);
    }
}
