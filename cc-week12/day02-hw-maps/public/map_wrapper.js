const MapWrapper = function(container, centre, zoomLevel) {
  // console.log(container);
  this.googleMap = new google.maps.Map(container, {
    center: centre,
    zoom: zoomLevel
  });

  this.markers = [];
}

MapWrapper.prototype.addMarker = function(coords) {
  const marker = new google.maps.Marker({
    map: this.googleMap,
    position: coords
  });

  const lat = marker.getPosition().lat();
  const long = marker.getPosition().lng();

  const contentString = `This point has coordinates (${lat}, ${long}).`;
  // Ask instructors how to get address from coords and print out that.
  console.log(contentString);

  const infoWindow = new google.maps.InfoWindow({
    content: contentString
  });

  marker.addListener('click',() => {
    infoWindow.open(this.googleMap, marker);
  });
  this.markers.push(marker);
}

MapWrapper.prototype.addClickListener = function () {
  google.maps.event.addListener(this.googleMap, 'click', (event) => {
    const lat = event.latLng.lat();
    const long = event.latLng.lng();
    this.addMarker({lat: lat, lng: long});
  });

  MapWrapper.prototype.setCenter = function (coords) {
    this.googleMap.setCenter(coords);
  };
}
