package com.fkadu.billing_service.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class.getName());

    @Override
    public void createBillingAccount(BillingRequest billingRequest,
                                     StreamObserver<BillingResponse> responseObserver){
        log.info("createBillingAccount request received : {}", billingRequest);

        // BUSINESS LOGIC

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("1234")
                .setStatus("Active")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
