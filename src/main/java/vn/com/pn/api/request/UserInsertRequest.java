package vn.com.pn.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInsertRequest extends BaseRequest{
    private String name;
    private String email;
    private String phone;
    private String password;
}
