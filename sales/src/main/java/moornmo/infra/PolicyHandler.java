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
    SalesRepository salesRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ProductionCompleted'"
    )
    public void wheneverProductionCompleted_UpdateStatus(
        @Payload ProductionCompleted productionCompleted
    ) {
        ProductionCompleted event = productionCompleted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + productionCompleted + "\n\n"
        );

        Sales.updateStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
