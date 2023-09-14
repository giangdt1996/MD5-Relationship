package ra.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {
    @NotEmpty
    private String fullName;
    @Min(value = 18)
    @Max(value = 100)
    private int age;

    private boolean sex;
    @Pattern(regexp = "^(.+)@(\\S+)$",message = "Email is not valid")
    private String email;
    @Pattern(regexp = "^0\\d{9,10}$",message = "Phone Number is not valid")
    private String phoneNumber;
}
