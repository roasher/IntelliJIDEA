package presentation.navigation_inside_class;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ru.yurkinsworkshop.tddexample.client.VozovozClient;
import ru.yurkinsworkshop.tddexample.dto.ProductAvailability;
import ru.yurkinsworkshop.tddexample.dto.Update;
import ru.yurkinsworkshop.tddexample.service.exception.VozovozException;
import ru.yurkinsworkshop.tddexample.service.manualexclusion.ManualExclusionService;
import ru.yurkinsworkshop.tddexample.service.notifier.AvailabilityNotifier;

import java.io.BufferedReader;
import java.util.regex.Pattern;

@Service
@Slf4j
public class FileEditing {

    private final AvailabilityNotifier availabilityNotifier;
    private final VozovozClient vozovozClient;
    private final ManualExclusionService manualExclusionService;

    public FileEditing(VozovozClient vozovozClient, ManualExclusionService manualExclusionService,
                       @Qualifier("lazyAvailabilityNotifier") AvailabilityNotifier availabilityNotifier) {
        this.vozovozClient = vozovozClient;
        this.manualExclusionService = manualExclusionService;
        this.availabilityNotifier = availabilityNotifier;
    }

    public void processUpdate(Update update) {
        if (update.getProductQuantity() <= 0) {
            availabilityNotifier.notify(getNotAvailableProduct(update.getProductId()));
            return;
        }
        if ("Blue".equals(update.getColor())) {
            availabilityNotifier.notify(getNotAvailableProduct(update.getProductId()));
            return;
        }
        if (!manualExclusionService.isProductEnabled(update.getProductId())) {
            availabilityNotifier.notify(getNotAvailableProduct(update.getProductId()));
            return;
        }
        try {
            final boolean availableForTransportation = vozovozClient.isAvailableForTransportation(update.getProductId());
            availabilityNotifier.notify(new ProductAvailability(update.getProductId(), availableForTransportation));
        } catch (Exception exception) {
            log.warn("Problems communicating with Vozovoz", exception);
            throw new VozovozException();
        }
    }

    private ProductAvailability getNotAvailableProduct(Long productId) {
        return new ProductAvailability(productId, false);
    }

    private void constructorParametersExample() {
//        new ErrorNavigation.House();
//        new ErrorNavigation.House("asdf", 23, 3, );
    }

    private void parametersTypeExample() {
        // todo
    }

    private void stringConcat() {
        String str = "This is a very very very very very very long line that I want to separate in order to read it easily";
    }

    private void injectionLanguages() {
        // if you like to write json in test
        new ru.yurkinsworkshop.tddexample.web.Controller(null, null);

        Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }

}
