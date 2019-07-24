package main;

import java.util.List;

public class Coordinates {
    private Point x;
    private Point y;

    public Point getX() {
        return x;
    }

    public void setX(Point x) {
        this.x = x;
    }

    public Point getY() {
        return y;
    }

    public void setY(Point y) {
        this.y = y;
    }

    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction value) {
        direction = value;
    }

    private List<Obstacle> obstacles;

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> value) {
        obstacles = value;
    }

    private boolean foundObstacle = false;

    public Coordinates(Point xValue, Point yValue, Direction direction, List<Obstacle> obstacles) {
        setX(xValue);
        setY(yValue);
        setDirection(direction);
        setObstacles(obstacles);
    }

    protected boolean move(Direction directionValue) {
        int xLocation = x.getLocation();
        int yLocation = y.getLocation();
        switch (directionValue) {
            case NORTH:
                yLocation = y.getForwardLocation();
                break;
            case EAST:
                xLocation = x.getForwardLocation();
                break;
            case SOUTH:
                yLocation = y.getBackwardLocation();
                break;
            case WEST:
                xLocation = x.getBackwardLocation();
                break;
        }

        if (!hasObstacle(xLocation, yLocation)) {
            x.setLocation(xLocation);
            y.setLocation(yLocation);
            return true;
        } else {
            return false;
        }
    }

    private boolean hasObstacle(int xLocation, int yLocation) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getX() == xLocation && obstacle.getY() == yLocation){
                foundObstacle = true;
                return true;
            }
        }
        return false;
    }

    public boolean moveForward() {
        return move(direction);
    }

    public boolean moveBackward() {
        return move(direction.getBackwardDirection());
    }

    private void changeDirection(Direction directionValue, int directionStep) {
        int directions = Direction.values().length;
        int index = (directions + directionValue.getValue() + directionStep) % directions;
        direction = Direction.values()[index];
    }

    public void changeDirectionLeft() {
        changeDirection(direction, -1);
    }

    public void changeDirectionRight() {
        changeDirection(direction, 1);
    }

    @Override
    public String toString() {
        String status = "";
        if (foundObstacle) {
            status = "KNOCK";
        }
        return getX().getLocation() + " X " + getY().getLocation() + " " + getDirection().getShortNam() + status;
    }
}
