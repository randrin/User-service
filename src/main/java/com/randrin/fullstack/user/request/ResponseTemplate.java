package com.randrin.fullstack.user.request;

import com.randrin.fullstack.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {

    private User user;
    private Department department;
}
