package com.major.user_service.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GetUserResponse {
    private String name;
    private String mobile;
    private String email;
    private Integer age;
    private Date createdOn;
    private Date updatedOn;
}
