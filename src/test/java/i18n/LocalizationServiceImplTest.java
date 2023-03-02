package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    LocalizationServiceImpl localizationService;

    @Test
    void locale_RUSSIA() {
        localizationService = new LocalizationServiceImpl();
        String expected = "Добро пожаловать";
        String result = localizationService.locale(Country.RUSSIA);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void USA() {
        localizationService = new LocalizationServiceImpl();
        String expected = "Welcome";
        String result = localizationService.locale(Country.USA);

        Assertions.assertEquals(expected, result);
    }
}