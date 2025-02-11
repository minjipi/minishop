package com.mini.shop.abc;

import com.mini.shop.abc.model.Abc;
import com.mini.shop.abc.model.AbcDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbcService {
    private final AbcRepository abcRepository;

    public List<AbcDto.AbcRes> list() {
        List<Abc> result = abcRepository.findAll();

//        List<AbcDto.AbcRes> responseList = new ArrayList<>();
//
//        for (Abc abc : result) {
//            AbcDto.AbcRes response = AbcDto.AbcRes.of(abc);
//            responseList.add(response);
//        }
//        return responseList;

        return result.stream().map(AbcDto.AbcRes::of).toList();
    }

    public AbcDto.AbcRes read(Long abcIdx) {
        Abc result = abcRepository.findById(abcIdx).orElseThrow();


        return AbcDto.AbcRes.of(result);
    }

    public AbcDto.AbcRes register(AbcDto.AbcReq dto) {
        Abc result = abcRepository.save(dto.toEntity());

        return AbcDto.AbcRes.of(result);
    }
}
