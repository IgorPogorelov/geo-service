package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static ru.netology.geo.GeoServiceImpl.MOSCOW_IP;
import static ru.netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

class MessageSenderImplTest {


    MessageSender messageSenderTest;
    GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);
    LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);

    @Test
    void send_test_Russia() {

        messageSenderTest = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        Mockito.when(geoService.byIp(anyString())).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        String result = messageSenderTest.send(headers);

        Assertions.assertEquals(result, "Добро пожаловать");
    }

    @Test
    void send_test_USA() {

        messageSenderTest = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.123.12.19");
        Mockito.when(geoService.byIp(anyString())).thenReturn(new Location("New York", Country.USA, null,  0));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        String result = messageSenderTest.send(headers);

        Assertions.assertEquals(result, "Welcome");
    }
}