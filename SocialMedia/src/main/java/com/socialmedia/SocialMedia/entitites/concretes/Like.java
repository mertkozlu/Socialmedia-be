package com.socialmedia.SocialMedia.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "likes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Like {

    @Id
    private Long likesId;
    private Long postId;
    private Long userId;
}
