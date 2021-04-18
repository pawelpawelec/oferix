package pl.oferix.offer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OfferController {

    OfferRepository repository;

    @PostMapping("offers")
    ResponseEntity addOffer(@RequestBody OfferDto request) {
        repository.save(Offer.fromDto(request));
        return ResponseEntity.ok().build();
    }

    @GetMapping("offers")
    List<Offer> offers(@RequestBody OfferDto request) {
        return repository.findAll();
    }
}
