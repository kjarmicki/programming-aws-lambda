package book;

public class WeatherEvent {
    public String locationName;
    public long temperature;
    public long timestamp;
    public double latitude;
    public double longitude;

    public WeatherEvent() {

    }

    public WeatherEvent(String locationName, long temperature, long timestamp, double latitude, double longitude) {
        this.locationName = locationName;
        this.temperature = temperature;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
