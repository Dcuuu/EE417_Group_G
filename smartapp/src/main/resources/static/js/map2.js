var map = L.map('map', {
    minZoom: 1,
    maxZoom: 4,
    center: [0, 0],
    zoom: 1, 
    crs: L.CRS.Simple
});

// Create a custom control for the information panel
var InfoControl = L.Control.extend({

    onAdd: function (map) {
        var div = L.DomUtil.create('div', 'info');
        updateInfo(); // Initialize
        setInterval(updateInfo, 2000); // Update every 2 seconds
        function updateInfo() {
            div.innerHTML = '<h4>Campus environment information</h4>' +
                'Temperature: ' + (Math.random() * 5 + 20).toFixed(2) + ' °C<br>' +
                'Humidity: ' + (Math.random() * 20 + 60).toFixed(2) + ' %<br>' +
                'Air quality: ' + (Math.random() * 50 + 50).toFixed(2);
        }
        return div;
    },

});

var southWest = map.unproject([0, 1068], map.getMaxZoom() - 1);
var northEast = map.unproject([1579, 0], map.getMaxZoom() - 1);
var bounds = new L.LatLngBounds(southWest, northEast);

L.imageOverlay('images/map.jpg', bounds).addTo(map);

map.fitBounds(bounds);

// Add the info control to the map
new InfoControl().addTo(map);

var locations = [
    { coords: [540, 1000], message: "Library", peopleCount: 100 },
    { coords: [1750, 1400], message: "Buiness school : busy", peopleCount: 100 },
    { coords: [280, 1000], message: "Car park 4", peopleCount: 200 },
    { coords: [320, 1370], message: "Invent", peopleCount: 100 },
    { coords: [800, 1200], message: "Lonsdale", peopleCount: 200 },
    { coords: [600, 1400], message: "NICB", peopleCount: 100 },
    { coords: [500, 1800], message: "NRF", peopleCount: 200 },
    { coords: [1000, 1700], message: "The Healthy Living Centre", peopleCount: 200 },
    { coords: [1250, 1200], message: "Marconi", peopleCount: 100 },
    { coords: [1200, 1400], message: "Stokes", peopleCount: 100 },
    { coords: [1500, 1200], message: "McNulty", peopleCount: 100 },
    { coords: [1750, 1700], message: "Car Park Multi-storey", peopleCount: 100 },
    { coords: [2050, 1700], message: "Eatates Office", peopleCount: 100 },
    { coords: [2200, 1400], message: "The Helix", peopleCount: 100 },
    { coords: [2200, 1100], message: "Henry Grattan", peopleCount: 100 },
    { coords: [900, 200], message: "Sports Car Park", peopleCount: 100 },
    { coords: [900, 500], message: "Residences Car Park", peopleCount: 200 },
    { coords: [850, 700], message: "Soccer Centre", peopleCount: 200 },
    { coords: [1100, 500], message: "Hamstead Residences", peopleCount: 200 },
    { coords: [1100, 800], message: "Larkfield Residences", peopleCount: 200 },
    { coords: [320, 1800], message: "Car Park 3", peopleCount: 100 },
    { coords: [1550, 800], message: "The Hub", peopleCount: 100 },
    { coords: [2050, 800], message: "Hamilton", peopleCount: 100 },
    { coords: [1250, 1200], message: "Marconi", peopleCount: 100 },
    { coords: [2700, 1200], message: "Car Park 2", peopleCount: 100 },

    // add more here
];

locations.forEach(function (location) {
    var latLng = map.unproject(location.coords, map.getMaxZoom());
    var markerOptions = {};

    if (location.peopleCount > 100) {
        // When the number of people exceeds 100, use a custom red marker
        markerOptions.icon = new L.Icon({
            iconUrl: 'images/red-marker-icon.png', 
            iconSize: [40, 41],
            iconAnchor: [12, 41],
            popupAnchor: [1, -34],
            shadowSize: [41, 41]
        });
    }

    var marker = L.marker(latLng, markerOptions).addTo(map);
    marker.bindPopup(location.message);

    marker.on('mouseover', function (e) {
        this.openPopup();
    });
    marker.on('mouseout', function (e) {
        this.closePopup();
    });
});
