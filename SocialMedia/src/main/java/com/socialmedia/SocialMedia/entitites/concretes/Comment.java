package com.socialmedia.SocialMedia.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    private Long commentId;
    private Long postId;
    private Long userId;
    @Lob
    @Column(columnDefinition = "text")
    private String text;
}
