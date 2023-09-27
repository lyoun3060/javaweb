package com.example.demo.dto;

import lombok.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {

    private Long tno;

    @NotEmpty
    private String title;

    @Future //현재시간보다 미래시간인가 = 현재보다 과거는 안된다는말?
    private LocalDate dueDate;

    @NotEmpty
    private String writer;

    //오류가 발생한 이유
    //boolean과 Boolean은 차이가 있다
    //boolean -> true, false (o), null(x)
    //Boolean -> treu, false, null (o)
    private Boolean finished;

}
