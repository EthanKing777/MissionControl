package org.group11.controller;

public class MapBox {
  
  private static final String apiKey = "pk.eyJ1IjoiY3ZidXJ0MDgiLCJhIjoiY2tkcDdjaGE5MXprZjJycGR2N2FhN2Q3OSJ9.WHW0WMAG5hF6xhtehdo3EQ";
  private static double LNG = 0;
  private static double LAT = 0;
  private static String LANDINGSITES = null;
  
  // Constructor to be used once issues of parsing data amongst controllers is solved
  
//  public MapBox(double lat, double lng) {
//    LAT = lat;
//    LNG = lng;
//    LANDINGSITES = null;
//  }

  public static String generateApiCall(String width, String height, String zoom) {
    //first return statement to be used when geojson function is added.
    if(LANDINGSITES != null) {
      return "https://api.mapbox.com/styles/v1/mapbox/satellite-streets-v11/static/geojson("+LANDINGSITES+")/"+LNG+","+LAT+","+zoom+"/"+height+"x"+width+"@2x?access_token="+apiKey;
    }
    
    return "https://api.mapbox.com/styles/v1/mapbox/satellite-streets-v11/static/"+LNG+","+LAT+","+zoom+"/"+height+"x"+width+"@2x?access_token="+apiKey;
  }
  
  
  /**
   * Sets the latitude and longitude for mapbox to render a static image of that location. 
   * @param lat latitude
   * @param lng longitude
   */
  public static void setLatLng(double lat, double lng) {
    LAT = lat;
    LNG = lng;
  }
  
  /**
   * Take a url encode json array and stores to mapbox object so map bx can render an overlay,
   * on top of the static map;
   * @param jsonUrl the encoded json arrray
   */
  public static void setLandingLocations (String jsonUrl) {
    LANDINGSITES = jsonUrl;
  }
}
