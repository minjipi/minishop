package com.mini.shop.abc;


import com.mini.shop.abc.model.AbcDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/abc")
public class AbcController {
    private final AbcService abcService;

    @GetMapping("/list")
    public ResponseEntity<List<AbcDto.AbcRes>> list() {
        List<AbcDto.AbcRes> response =  abcService.list();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/read/{abcIdx}")
    public ResponseEntity<AbcDto.AbcRes> read(@PathVariable Long abcIdx) {
        AbcDto.AbcRes response =  abcService.read(abcIdx);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<AbcDto.AbcRes> read(@RequestBody AbcDto.AbcReq dto) {
        AbcDto.AbcRes response =  abcService.register(dto);

        return ResponseEntity.ok(response);
    }
}
