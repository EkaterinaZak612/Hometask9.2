import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    public void shouldSetCurrentStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(3);
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetCurrentStationIfStationIsLessThanZero() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetCurrentStationIfStationIsEqualToMaxStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(4);
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToNextStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(3);
        radio.nextStation();
        assertEquals(4, radio.getCurrentStation());
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToPreviousStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
        radio.prevStation();
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio(5);
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeIfVolumeIsAlreadyMax() {
        Radio radio = new Radio(5);
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio(5);
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeIfVolumeIsAlreadyMin() {
        Radio radio = new Radio(5);
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetMaxStationToFourByDefault() {
        Radio radio = new Radio();
        assertEquals(4, radio.getMaxStation());
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
        Radio radio = new Radio(5);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetCurrentVolumeIfValueIsGreaterThanMaxVolume() {
        Radio radio = new Radio(5);
        radio.setCurrentVolume(150);
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetCurrentVolumeIfValueIsLessThanMinVolume() {
        Radio radio = new Radio(5);
        radio.setCurrentVolume(-50);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldWrapAroundToFirstStationIfNextButtonPressedOnLastStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(4);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldWrapAroundToLastStationIfPrevButtonPressedOnFirstStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldNotChangeStationIfNextButtonPressedOnLastStationWithOnlyOneStation() {
        Radio radio = new Radio(1);
        radio.setCurrentStation(0);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotChangeStationIfPrevButtonPressedOnFirstStationWithOnlyOneStation() {
        Radio radio = new Radio(1);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSetCurrentStationToMaxStationIfValueIsGreaterThanMaxStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(10);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldSetCurrentStationToMinStationIfValueIsLessThanMinStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(-5);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSetCurrentVolumeToMaxVolumeIfValueIsGreaterThanMaxVolume() {
        Radio radio = new Radio(5);
        radio.setCurrentVolume(150);
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetCurrentVolumeToMinVolumeIfValueIsLessThanMinVolume() {
        Radio radio = new Radio(5);
        radio.setCurrentVolume(-50);
        assertEquals(0, radio.getCurrentVolume());
    }
}
