package moornmo.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import moornmo.config.kafka.KafkaProcessor;
import moornmo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ProductionRepository productionRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SalesRegistered'"
    )
    public void wheneverSalesRegistered_AddProductionSchedule(
        @Payload SalesRegistered salesRegistered
    ) {
        SalesRegistered event = salesRegistered;
        System.out.println(
            "\n\n##### listener AddProductionSchedule : " +
            salesRegistered +
            "\n\n"
        );

        // Sample Logic //
        Production.addProductionSchedule(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
