package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.geo.GeoServiceImpl.*;

class GeoServiceImplTest {

    GeoService geoServiceImpl;

    @Test
    void byIp_MOSCOW_IP() {

        geoServiceImpl = new GeoServiceImpl();
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location result = geoServiceImpl.byIp(MOSCOW_IP);

        Assertions.assertEquals(expected.getCity(), result.getCity());
        Assertions.assertEquals(expected.getCountry(), result.getCountry());
        Assertions.assertEquals(expected.getStreet(), result.getStreet());
        Assertions.assertEquals(expected.getBuiling(), result.getBuiling());

    }

    @Test
    void byIp_LOCALHOST() {

        geoServiceImpl = new GeoServiceImpl();
        Location expected = new Location(null, null, null, 0);
        Location result = geoServiceImpl.byIp(LOCALHOST);

        Assertions.assertEquals(expected.getCity(), result.getCity());
        Assertions.assertEquals(expected.getCountry(), result.getCountry());
        Assertions.assertEquals(expected.getStreet(), result.getStreet());
        Assertions.assertEquals(expected.getBuiling(), result.getBuiling());

    }

    @Test
    void byIp_NEW_YORK_IP() {

        geoServiceImpl = new GeoServiceImpl();
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location result = geoServiceImpl.byIp(NEW_YORK_IP);

        Assertions.assertEquals(expected.getCity(), result.getCity());
        Assertions.assertEquals(expected.getCountry(), result.getCountry());
        Assertions.assertEquals(expected.getStreet(), result.getStreet());
        Assertions.assertEquals(expected.getBuiling(), result.getBuiling());

    }
}