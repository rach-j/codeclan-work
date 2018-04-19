document.addEventListener('DOMContentLoaded', () => {
  const mapContainer = document.querySelector('#main-map');
  const centre = {lat: 55.966918, lng: -3.1931747999999516 };
  const mainMap = new MapWrapper(mapContainer, centre, 10);

  mainMap.addMarker(centre);
  mainMap.addMarker({lat: 55.946962, lng: -3.201958});
  mainMap.addClickListener();

  const buttonTimbuktu = document.querySelector('#button-timbuktu');
  buttonTimbuktu.addEventListener('click', handleTimbuktuButtonClick);

  const buttonMyLocation = document.querySelector('#button-my-location');
  buttonMyLocation.addEventListener('click', handleMyLocationButtonClick);
});

const handleTimbuktuButtonClick = (event) => {
  const newMapContainer = document.querySelector('#main-map');
  const map = new MapWrapper(newMapContainer, {lat: 0, lng: 0}, 10);
  map.setCenter({lat: 16.7735, lng: -3.0074});
}

const handleMyLocationButtonClick = function(event) {
  console.log('Button clicked');
  const newMapContainer = document.querySelector('#main-map');
  const map = new MapWrapper(newMapContainer, {lat: 0, lng: 0}, 10);
  navigator.geolocation.getCurrentPosition(function(position) {
  const initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
  map.setCenter(initialLocation);
}, failure);
}


failure = function(position) {
  console.log('finding position failed');
}
