package com.example.myapp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.util.concurrent.Executors;

@RestController
public class MyAppController {

    @PostMapping("/myapp")
    public RedirectView redirect(
            @RequestParam(name = "TransactionId", required = false) String transactionId,
            @RequestParam(name = "Response", required = false) String responseParam,
            @RequestParam(name = "MD", required = false) String md) {

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("https://rabhishek7.github.io/success-form/");
        return redirectView;
    }
     @PostMapping("/myapp1")
    public String abc(
            @RequestParam(name = "TransactionId", required = false) String transactionId,
            @RequestParam(name = "Response", required = false) String responseParam,
            @RequestParam(name = "MD", required = false) String md) {

       
        return "Abc";
    }

  @PostMapping("/myapp2")
  public SseEmitter streamEvents(
      @RequestParam(name = "TransactionId", required = false) String transactionId,
      @RequestParam(name = "Response", required = false) String responseParam,
      @RequestParam(name = "MD", required = false) String md) {

    SseEmitter emitter = new SseEmitter();

    Executors.newSingleThreadExecutor()
        .submit(
            () -> {
              try {
                emitter.send(SseEmitter.event().name("PROCEED"));
                emitter.complete(); // Close after sending one event
              } catch (Exception e) {
                emitter.completeWithError(e);
              }
            });

    return emitter;
  }

 
}
