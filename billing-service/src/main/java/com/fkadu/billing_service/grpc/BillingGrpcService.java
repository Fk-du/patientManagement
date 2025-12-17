package com.fkadu.billing_service.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {
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
