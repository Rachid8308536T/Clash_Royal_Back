package ClashRoyale.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserDTO {

    private String pseudonyme;
    private String password;
    private String role;
}
