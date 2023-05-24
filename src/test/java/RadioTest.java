import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    public void shouldSetCurrentStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetCurrentStationIfStationIsLessThanZero() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetCurrentStationIfStationIsEqualToMaxStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToNextStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(8);
        radio.nextStation();
        assertEquals(9, radio.getCurrentStation());
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToPreviousStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
        radio.prevStation();
        assertEquals(8, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio(10);
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeIfVolumeIsAlreadyMax() {
        Radio radio = new Radio(10);
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio(10);
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeIfVolumeIsAlreadyMin() {
        Radio radio = new Radio(10);
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetMaxStationToTenByDefault() {
        Radio radio = new Radio();
        assertEquals(10, radio.getMaxStation());
    }

    @Test
    public void shouldSetMaxStation() {
        Radio radio = new Radio(15);
        assertEquals(15, radio.getMaxStation());
    }

    @Test
    public void shouldSwitchToFirstStationIfNextButtonPressedOnMaxStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(4);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToLastStationIfPrevButtonPressedOnFirstStation() {
        Radio radio = new Radio(8);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(7, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetCurrentVolumeIfValueIsGreaterThanMaxVolume() {
        Radio radio = new Radio(10);
        radio.setCurrentVolume(150);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetCurrentVolumeIfValueIsLessThanMinVolume() {
        Radio radio = new Radio(10);
        radio.setCurrentVolume(-50);
        assertEquals(0, radio.getCurrentVolume());
    }
}
