package org.example;

public class PaymentAdapter implements OldPaymentGateway{
    private NewPaymentProcessor newPaymentProcessor;

    public PaymentAdapter(NewPaymentProcessor newPaymentProcessor) {

        this.newPaymentProcessor = newPaymentProcessor;
    }


    @Override
    public void makePayment(String accountNumber, double amount) {

    }
}
