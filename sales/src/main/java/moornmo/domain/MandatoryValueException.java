package moornmo.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
    code = HttpStatus.BAD_REQUEST,
    reason = "Some mandatory entry value is not present"
)
public class MandatoryValueException extends RuntimeException {

    public MandatoryValueException(String detail) {
        super("Some mandatory entry value is not present: " + detail);
    }
}
