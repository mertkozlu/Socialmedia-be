package com.socialmedia.SocialMedia.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long postId;
    private Long userId;
    private String title;

    @Lob
    @Column(columnDefinition = "text")
    private String text;

}
