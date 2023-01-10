package com.crudpractice.crud.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseHandler {
    private Boolean IsSuccess;
    private String Message;
    private Integer Status;
    private Object Data;
}
