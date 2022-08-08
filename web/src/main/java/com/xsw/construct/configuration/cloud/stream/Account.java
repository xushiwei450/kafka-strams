package com.xsw.construct.configuration.cloud.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements Serializable {

    private String userId;

    private String account;
}
