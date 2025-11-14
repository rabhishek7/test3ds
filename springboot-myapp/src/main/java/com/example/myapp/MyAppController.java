package com.example.myapp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MyAppController {

    @PostMapping("/myapp")
    public RedirectView redirect(
            @RequestParam(name = "TransactionId", required = false) String transactionId,
            @RequestParam(name = "Response", required = false) String responseParam,
            @RequestParam(name = "MD", required = false) String md) {

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("https://10.1.200.12/payment-confirmation-3ds");
        return redirectView;
    }
}
