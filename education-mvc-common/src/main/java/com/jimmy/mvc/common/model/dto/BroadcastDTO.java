package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.ReceiveTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName: BroadcastDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Data
@ApiModel("广播信息")
public class BroadcastDTO {
    @NotNull(message = "接收人的类型不能为空")
    @ApiModelProperty("接收人的类型")
    private ReceiveTypeEnum receiveType;
    @ApiModelProperty("接收机器的ID")
    private List<Long> machineIdList;
    @NotBlank(message = "广播的内容不能为空")
    @ApiModelProperty("广播的内容")
    private String content;
}
