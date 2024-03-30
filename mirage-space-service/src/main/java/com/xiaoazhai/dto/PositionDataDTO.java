package com.xiaoazhai.dto;

import lombok.Data;

import java.util.List;

@Data
public class PositionDataDTO {

    private List<CommonResourceDTO> commonResourceDTOList;

    private String positionCode;

    private String traceId;


}
