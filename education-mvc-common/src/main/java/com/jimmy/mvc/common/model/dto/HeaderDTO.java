package com.jimmy.mvc.common.model.dto;

import com.jimmy.dao.entity.StudentInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName: HeaderDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/12/012.
 */
@Data
@ApiModel("ͷ��������Ϣ")
public class HeaderDTO implements Serializable {
    private static final long serialVersionUID = 4125013116058034535L;
    @ApiModelProperty("ͷ����Ϣ")
    @NotBlank(message = "ͷ����Ϣ����Ϊ��",groups = {Teacher.class, Student.class})
    private String header;
    @ApiModelProperty("��Ӧ��ѧ��/��ʦID")
    @NotNull(message = "��Ӧ��ѧ��/��ʦIDID����Ϊ��",groups = {Student.class})
    private Long userId;

    public interface Teacher{}
    public interface Student{}
}
