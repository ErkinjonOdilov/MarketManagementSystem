package uz.market.market.web.rest;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.market.market.domain.PaymentList;
import uz.market.market.service.PaymentListService;

@RestController
@RequestMapping("/api")
public class PaymentListResource {
    private final PaymentListService paymentListService;

    public PaymentListResource(PaymentListService paymentListService) {
        this.paymentListService = paymentListService;
    }

    @PostMapping("/payment-list")
    public ResponseEntity create(@RequestBody PaymentList paymentList){
        PaymentList newPaymentList = paymentListService.save(paymentList);
        return ResponseEntity.ok(newPaymentList);
    }

    @PutMapping("/payment-list")
    public ResponseEntity update(@RequestBody PaymentList paymentList){
        PaymentList newPaymentList = paymentListService.save(paymentList);
        return ResponseEntity.ok(newPaymentList);
    }

    @GetMapping("/payment-list/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        PaymentList paymentList = paymentListService.findOne(id);
        return ResponseEntity.ok(paymentList);
    }

    @GetMapping("/payment-list")
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<PaymentList> paymentList = paymentListService.findAll(pageable);
        return ResponseEntity.ok(paymentList);
    }

    @DeleteMapping("/payment-list/{id}")
    public void delete(@PathVariable Long id){
        paymentListService.delete(id);
    }

}
