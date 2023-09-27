package com.example.demo.mapper;

import com.example.demo.domain.TodoVO;
import com.example.demo.dto.PageRequestDTO;
import com.sun.tools.javac.comp.Todo;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);


}
