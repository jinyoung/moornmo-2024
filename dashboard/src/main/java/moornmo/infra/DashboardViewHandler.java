package moornmo.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import moornmo.config.kafka.KafkaProcessor;
import moornmo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSalesRegistered_then_CREATE_1(
        @Payload SalesRegistered salesRegistered
    ) {
        try {
            if (!salesRegistered.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setSalesStatus("INIT");
            dashboard.setCustomerId(salesRegistered.getCompanyId());
            dashboard.setId(salesRegistered.getId());
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenProductionScheduled_then_UPDATE_1(
        @Payload ProductionScheduled productionScheduled
    ) {
        try {
            if (!productionScheduled.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(
                productionScheduled.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setProductionStatus("SCHEDULED");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenProductionCompleted_then_UPDATE_2(
        @Payload ProductionCompleted productionCompleted
    ) {
        try {
            if (!productionCompleted.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(
                productionCompleted.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setProductionStatus("COMPLETED");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
