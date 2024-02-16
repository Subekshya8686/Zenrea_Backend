package com.example.zenrea_backend.service.impl;

import com.example.zenrea_backend.dto.ListDto;
import com.example.zenrea_backend.entity.BoardList;
import com.example.zenrea_backend.repository.ListRepository;
import com.example.zenrea_backend.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListServiceImpl implements ListService {

    private final ListRepository listRepo;

    @Override
    public String save(ListDto listDto) {
        BoardList list = new BoardList();
        if(listDto.getId()!=null) {
            list=listRepo.findById((listDto.getId())).orElseThrow(() ->new NullPointerException("data not found"));
        }

        list.setName(listDto.getName());
        listRepo.save(list);
        return "created";
    }

    @Override
    public List<BoardList> getAll() {
        return listRepo.findAll();
    }

    @Override
    public Optional<BoardList> getById(Long id) {
        return listRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        listRepo.deleteById(id);
    }
}
