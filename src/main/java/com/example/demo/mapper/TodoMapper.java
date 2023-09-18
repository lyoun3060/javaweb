package com.example.demo.mapper;

import com.example.demo.domain.TodoVO;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);
}
