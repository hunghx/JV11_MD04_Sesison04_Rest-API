package ra.api.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAddDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Boolean sex;
}
