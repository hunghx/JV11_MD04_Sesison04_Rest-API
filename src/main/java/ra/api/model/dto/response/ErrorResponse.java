package ra.api.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
    private int code;
    private String message;
    private Object details;
}
