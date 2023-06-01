public class Radio {
    private int currentStation;
    private int minStation;
    private int currentVolume;
    private int maxStation;
    private final int MAX_VOLUME = 100;
    private final int MIN_VOLUME = 0;

    public Radio() {
        this.maxStation = 4; // По умолчанию 5 станций (индексация с 0 до 4)
        this.minStation = 0; // По умолчанию минимальная станция 0
    }
    public Radio(int maxStation) {
        this.currentStation = 0;
        this.minStation = 0;
        this.maxStation = maxStation - 1;
        this.maxStation = maxStation;
    }

    public void setCurrentStation(int station) {
        if (station < minStation) {
            this.currentStation = minStation;
        } else if (station > maxStation) {
            this.currentStation = maxStation;
        } else {
            currentStation = station;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void nextStation() {
        if (currentStation == maxStation - 1) {
            currentStation = 0; // Переключение на первую станцию
        } else {
            currentStation++; // Переключение на следующую станцию
        }
    }

    public void prevStation() {
        if (currentStation == 0) {
            currentStation = maxStation - 1;
        } else {
            currentStation--;
        }
    }

    public void increaseVolume() {
        if (currentVolume < MAX_VOLUME) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > MIN_VOLUME) {
            currentVolume--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int volume) {
        if (volume > MAX_VOLUME) {
            currentVolume = MAX_VOLUME;
        } else if (volume < MIN_VOLUME) {
            currentVolume = MIN_VOLUME;
        } else {
            currentVolume = volume;
        }
    }

    public int getMaxStation() {
        return maxStation;
    }
}
