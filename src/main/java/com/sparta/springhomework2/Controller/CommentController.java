package com.sparta.springhomework2.Controller;

import com.sparta.springhomework2.dto.CommentRequestDto;
import com.sparta.springhomework2.dto.CommentResponseDto;
import com.sparta.springhomework2.dto.StatusResponseDto;
import com.sparta.springhomework2.security.UserDetailsImpl;
import com.sparta.springhomework2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;


    // 생성
    @PostMapping("/comment/{id}")
    public StatusResponseDto<CommentResponseDto> createComment(@PathVariable Long id,
                                                               @RequestBody CommentRequestDto requestDto,
                                                               @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.createComment(id, requestDto, userDetails);
    }
    // 조회
    @GetMapping("/comment/{id}")
    public StatusResponseDto<CommentResponseDto> getComment(@PathVariable Long id){
        return commentService.findComment(id);
    }

    // 수정
    @PutMapping ("/comment/{id}")
    public StatusResponseDto<CommentResponseDto> updateComment(@PathVariable Long id,
                                                               @RequestBody CommentRequestDto commentRequestDto,
                                                               @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.updateComment(id, commentRequestDto, userDetails);
    }

    //삭제
    @DeleteMapping("/comment/{id}")
    public StatusResponseDto<String> deleteComment(@PathVariable Long id,
                                                   @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.deleteComment(id, userDetails);
    }

}