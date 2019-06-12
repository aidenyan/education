package com.jimmy.mvc.common.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: MachineStudentDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Data
public class MachineStudentDTO {
    /**
     * ����ID
     */
    private Long machineId;
    /**
     * �μ�ID
     */
    private Long courewareId;
    /**
     * ѧ���б�
     */
    private List<Long> studentIdList;
}
