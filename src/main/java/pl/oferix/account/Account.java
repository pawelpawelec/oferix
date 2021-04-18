package pl.oferix.account;

import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Account {

    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;

    static Account fromDto(AccountDto dto) {
        Account account = new Account();
        account.email = dto.getEmail();
        account.surname = dto.getSurname();
        account.name = dto.getName();
        account.password = DigestUtils.sha256Hex(dto.getPassword());
        return account;
    }
}
