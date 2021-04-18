package pl.oferix.account;

import lombok.AllArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

    AccountRepository repository;

    @PostMapping("users")
    ResponseEntity createUser(@RequestBody AccountDto request) {
       if (repository.findByEmail(request.getEmail()).isPresent())
           return ResponseEntity.badRequest().build();
        repository.save(Account.fromDto(request));
        return ResponseEntity.ok().build();
    }

    @PostMapping("login")
    ResponseEntity login(@RequestBody LoginDto login) {
        return repository.findByEmailAndPassword(login.getLogin(),
                DigestUtils.sha256Hex(login.getPassword()))
                .isPresent() ?
                ResponseEntity.ok().build() :
                ResponseEntity.badRequest().build();
    }
}
