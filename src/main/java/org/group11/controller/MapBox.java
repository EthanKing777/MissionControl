package org.group11.controller;

public class MapBox {
  
  private static String apiKey = "pk.eyJ1IjoiY3ZidXJ0MDgiLCJhIjoiY2tkcDdjaGE5MXprZjJycGR2N2FhN2Q3OSJ9.WHW0WMAG5hF6xhtehdo3EQ";
  private static double LNG = 0;
  private static double LAT = 0;
  private static String LANDINGSITES;

  public static String generateApiCall(String width, String height, String zoom) {
    //first return statement to be used when geojson function is added.
    //return "https://api.mapbox.com/styles/v1/mapbox/geojson("+LANDINGSITES+")/satellite-streets-v11/static/"+LNG+","+LAT+","+zoom+"/"+height+"x"+width+"@2x?access_token="+apiKey;
    return "https://api.mapbox.com/styles/v1/mapbox/satellite-streets-v11/static/"+LNG+","+LAT+","+zoom+"/"+height+"x"+width+"@2x?access_token="+apiKey;
  }
  
  
  public static void setLatLng(double lat, double lng) {
    LAT = lat;
    LNG = lng;
  }
  
  public static void setLandingLocations (String jsonUrl) {
    LANDINGSITES = jsonUrl;
  }
}
