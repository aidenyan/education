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
@ApiModel("�㲥��Ϣ")
public class BroadcastDTO {
    @NotNull(message = "�����˵����Ͳ���Ϊ��")
    @ApiModelProperty("�����˵�����")
    private ReceiveTypeEnum receiveType;
    @ApiModelProperty("���ջ�����ID")
    private List<Long> machineIdList;
    @NotBlank(message = "�㲥�����ݲ���Ϊ��")
    @ApiModelProperty("�㲥������")
    private String content;
}
