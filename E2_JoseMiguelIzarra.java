class GeoPoint {
    double lat, lon;
    GeoPoint(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
class MapMarker {
    GeoPoint geoPoint = new GeoPoint(0,0);
    String title;
    int color;
    @Override
    public String toString() {
        return "{ latitude: " + geoPoint.lat + ", longitude: " + geoPoint.lon +
                ", title: '" + title + "', color: " + color + " }";
    }

    static class Builder {
        String title;
        int color;
        double lat, lon;
        GeoPoint geoPoint = new GeoPoint(lat,lon);

        Builder setGeoPoint(GeoPoint geoPoint){
            this.geoPoint = geoPoint;
            return this;
        }

        Builder setTitle(String title){
            this.title = title;
            return this;
        }

        Builder setColor(int color){
            this.color = color;
            return this;
        }

        Builder setLatitude(double lat){
            this.lat = lat;
            return this;
        }


        Builder setLongitude(double lon){
            this.lon = lon;
            return this;
        }

        MapMarker build(){
            MapMarker mapMarker = new MapMarker();

            mapMarker.geoPoint = this.geoPoint;
            mapMarker.title = this.title;
            mapMarker.color = this.color;
            mapMarker.geoPoint.lat = this.lat;
            mapMarker.geoPoint.lon = this.lon;

            return mapMarker;
        }

    }
}
public class E2_JoseMiguelIzarra {
    public static void main(String[] args) {
        MapMarker mapMarker = new MapMarker.Builder()
                .setLatitude(39.82185)
                .setLongitude(-0.22444)
                .setTitle("IES Benigaslo")
                .setColor(0xFF3322)
                .build();
        System.out.println(mapMarker);
    }
}