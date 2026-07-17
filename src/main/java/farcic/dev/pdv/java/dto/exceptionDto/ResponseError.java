package farcic.dev.pdv.java.dto.exceptionDto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResponseError(

        String message,
        int status,
        LocalDateTime timeStamp

){
}
