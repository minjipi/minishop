package com.mini.shop.abc.model;

import lombok.Builder;
import lombok.Getter;

public class AbcDto {
    @Getter
    public static class AbcReq {
        private String var01;
        private int var02;

        // Dto -> Entity 바꾸는 것
        public Abc toEntity() {
            return Abc.builder()
                    .var01(var01)
                    .var02(var02)
                    .build();
        }
    }

    @Getter @Builder
    public static class AbcRes {
        private Long idx;
        private String var01;
        private int var02;

        // Entity -> Dto 바꾸는 것
        public static AbcRes of(Abc entity) {
            return AbcRes.builder()
                    .idx(entity.getIdx())
                    .var01(entity.getVar01())
                    .var02(entity.getVar02())
                    .build();
        }
    }
}
