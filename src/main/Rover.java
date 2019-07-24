package main;

public class Rover {
    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates value) {
        coordinates = value;
    }

    public Rover(Coordinates coordinates) {
        setCoordinates(coordinates);
    }

    public void receiveCommands(String commands) throws Exception {
        for (char command : commands.toCharArray()){
            if (!receiveSingleCommand(command)){
                break;
            }
        }
    }

    public boolean receiveSingleCommand(char command) throws Exception {
        switch(Character.toUpperCase(command)) {
            case 'F':
                return getCoordinates().moveForward();
            case 'B':
                return getCoordinates().moveBackward();
            case 'L':
                getCoordinates().changeDirectionLeft();
                return true;
            case 'R':
                getCoordinates().changeDirectionRight();
                return true;
            default:
                throw new Exception("Command " + command + " is unknown.");
        }
    }

    public String getPosition() {
        return getCoordinates().toString();
    }
}
