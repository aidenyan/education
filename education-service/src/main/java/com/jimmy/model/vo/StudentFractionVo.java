package com.jimmy.model.vo;

import com.jimmy.dao.entity.StudentFraction;
import com.jimmy.dao.entity.StudentFractionItem;
import lombok.Data;

import java.util.List;

@Data
public class StudentFractionVo {
    private StudentFraction studentFraction;
    private List<StudentFractionItem> studentFractionItemList;
}
