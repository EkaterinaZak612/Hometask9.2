import org.junit.Test;
import static org.junit.Assert.*;

public class RadioTest {

    @Test
    public void shouldSetCurrentStation() {
        Radio radio = new Radio(4);
        radio.setCurrentStation(3);
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetCurrentStationIfStationIsLessThanMinStation() {
        Radio radio = new Radio(4);
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetCurrentStationIfStationIsGreaterThanMaxStation() {
        Radio radio = new Radio(4);
        radio.setCurrentStation(5);
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToNextStationWhenCurrentStationIsNotMaxStation() {
        Radio radio = new Radio(4);
        radio.setCurrentStation(3);
        radio.switchToNextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToMinStationWhenCurrentStationIsMaxStation() {
        Radio radio = new Radio(4);
        radio.setCurrentStation(4);
        radio.switchToNextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToPreviousStationWhenCurrentStationIsNotMinStation() {
        Radio radio = new Radio(4);
        radio.setCurrentStation(3);
        radio.switchToPreviousStation();
        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToMaxStationWhenCurrentStationIsMinStation() {
        Radio radio = new Radio(4);
        radio.setCurrentStation(0);
        radio.switchToPreviousStation();
        assertEquals(3, radio.getCurrentStation());
    }
}
