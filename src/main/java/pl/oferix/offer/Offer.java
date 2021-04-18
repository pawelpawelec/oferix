package pl.oferix.offer;

import org.apache.commons.codec.digest.DigestUtils;
import pl.oferix.account.Account;
import pl.oferix.account.AccountDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Offer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    static Offer fromDto(OfferDto dto) {
        Offer offer = new Offer();
        offer.name = dto.getName();
        offer.description = dto.getDescription();
        return offer;
    }
}
