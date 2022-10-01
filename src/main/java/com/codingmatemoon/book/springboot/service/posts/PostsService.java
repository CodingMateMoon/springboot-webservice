package com.codingmatemoon.book.springboot.service.posts;

import com.codingmatemoon.book.springboot.domain.posts.Posts;
import com.codingmatemoon.book.springboot.domain.posts.PostsRepository;
import com.codingmatemoon.book.springboot.web.dto.PostsListResponseDto;
import com.codingmatemoon.book.springboot.web.dto.PostsResponseDto;
import com.codingmatemoon.book.springboot.web.dto.PostsSaveRequestDto;
import com.codingmatemoon.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    // JPA 영속성 컨텍스트(엔티티 영구 저장 환경)을 활용하여 Entity 객체의 값 변경시 트랜잭션을 종료할 때 테이블에 변경분 반영(dirty checking)
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }
}
