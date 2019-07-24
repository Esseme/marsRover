package main;

public class Point {

    private int location;
    private int maxLocation;

    public int getLocation() {
        return location;
    }

    public void setLocation(int value) {
        location = value;
    }

    public int getMaxLocation() {
        return maxLocation;
    }

    public void setMaxLocation(int value) {
        maxLocation = value;
    }

    public Point(int location, int maxLocation) {
        setLocation(location);
        setMaxLocation(maxLocation);
    }

    public int getForwardLocation() {
        return (getLocation() + 1 ) % (getMaxLocation() + 1);
    }

    public int getBackwardLocation() {
        if (getLocation() > 0 ) return getLocation() - 1;
        else return getMaxLocation();
    }
}
