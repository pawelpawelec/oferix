package pl.oferix.account;

import lombok.Data;

@Data
public class AccountDto {
    private String name;
    private String surname;
    private String email;
    private String password;
}
