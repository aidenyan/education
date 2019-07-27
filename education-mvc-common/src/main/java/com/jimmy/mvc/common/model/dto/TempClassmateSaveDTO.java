package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: TempClassmateSaveDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/11/011.
 */
@Data
@ApiModel("�༶��ʱ��Ϣ�������")
public class TempClassmateSaveDTO implements Serializable {

    private static final long serialVersionUID = -8873260055802642987L;
    @NotEmpty(message = "ѡ���İ༶����Ϊ��")
    @ApiModelProperty("ѡ���İ༶")
    private List<Long> classMateIdList;
    @NotNull(message = "ѡ���Ŀγ̲���Ϊ��")
    @ApiModelProperty("ѡ���Ŀγ�")
    private Long courseId;
    @ApiModelProperty("��ʱ�༶������")
    private String name;
}
