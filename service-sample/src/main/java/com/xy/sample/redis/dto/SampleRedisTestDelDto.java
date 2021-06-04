package com.xy.sample.redis.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class SampleRedisTestDelDto {

    @NotBlank(message = "key不能为空")
    private String key;

}
