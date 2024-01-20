package com.ra.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRegister {
    @NotNull(message = "Không được rỗng")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được bỏ rỗng")
    private String fullName;
    @NotNull(message = "Không được rỗng")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được bỏ rỗng")
    @Size(min = 6, max = 100, message = "Tối thiểu 6 ký tự, tối đa 100 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Không có ký tự đặc biệt, không trùng lặp")
    private String username;
    @NotNull(message = "Không được rỗng")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được bỏ rỗng")
    private String password;
    @NotNull(message = "Không được rỗng")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được bỏ rỗng")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",message = "Không đúng định dạng")
    private String email;
    @NotNull(message = "Không được rỗng")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được bỏ rỗng")
    @Pattern(regexp = "^\\+84\\d{9,10}$", message = "Định dạng số điện thoại không đúng")
    private String phone;
    @NotNull(message = "Không được rỗng")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được bỏ rỗng")
    private String address;

}
