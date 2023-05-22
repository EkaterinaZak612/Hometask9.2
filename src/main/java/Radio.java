public class Radio {
    private int currentStation;
    private int minStation;
    private int maxStation;

    public Radio(int maxStation) {
        this.currentStation = 0;
        this.minStation = 0;
        this.maxStation = maxStation - 1;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < minStation) {
            this.currentStation = minStation;
        } else if (currentStation > maxStation) {
            this.currentStation = maxStation;
        } else {
            this.currentStation = currentStation;
        }
    }
    public void switchToNextStation() {
        if (currentStation == maxStation) {
            currentStation = minStation;
        } else {
            currentStation++;
        }
    }

    public void switchToPreviousStation() {
        if (currentStation == minStation) {
            currentStation = maxStation;
        } else {
            currentStation--;
        }
    }
}


