package com.su.ac.th.workshop.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse<T> {

    private Long status;
    private String message;
    private T data;

}
