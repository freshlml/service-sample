package com.sc.sample.dto.scan;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ScanDelDto {
    @NotNull(message = "id不能为空")
    private Long id;
}
