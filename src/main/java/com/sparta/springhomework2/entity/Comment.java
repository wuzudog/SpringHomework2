package com.sparta.springhomework2.entity;

import com.sparta.springhomework2.dto.CommentRequestDto;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor

public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

//    @OneToMany(mappedBy = "comment",fetch = FetchType.LAZY)
//    List<CommentLike> commentLikes = new ArrayList<>();

    @Builder
    public Comment(CommentRequestDto requestDto ,User user, Post post ) {
        this.user = user;
        this.post = post;
        this.content = requestDto.getContent();
    }

    public void update(CommentRequestDto requestDto){
        this.content = requestDto.getContent();
    }
}











