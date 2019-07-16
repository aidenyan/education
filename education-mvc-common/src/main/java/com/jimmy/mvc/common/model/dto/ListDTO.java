package com.jimmy.mvc.common.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: ListDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/16/016.
 */
@Data
public class ListDTO<T> implements Serializable {

    private static final long serialVersionUID = 6275352015223776857L;
    @NotEmpty(message = "数据列表不能为空")
    private List<T> result;
}
