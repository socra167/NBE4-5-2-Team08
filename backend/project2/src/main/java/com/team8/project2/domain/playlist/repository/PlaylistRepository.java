package com.team8.project2.domain.playlist.repository;

import com.team8.project2.domain.curation.tag.entity.Tag;
import com.team8.project2.domain.playlist.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 플레이리스트(Playlist) 데이터를 관리하는 레포지토리 인터페이스입니다.
 * 기본적인 CRUD 기능을 제공합니다.
 * 추천 기능을 위한 태그 기반 플레이리스트 검색 기능을 포함합니다.
 */
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    /**
     * 현재 플레이리스트의 태그를 기반으로 추천 플레이리스트를 조회하는 메서드입니다.
     * 전달받은 태그 집합에 포함된 태그를 가진 플레이리스트를 조회하며,
     * 현재 플레이리스트는 결과에서 제외합니다.
     *
     * @param tags 플레이리스트의 태그 목록
     * @param playlistId 현재 플레이리스트 ID
     * @return 추천 플레이리스트 목록
     */
    @Query("SELECT DISTINCT p FROM Playlist p JOIN p.tags t " +
            "WHERE t IN :tags AND p.id <> :playlistId")
    List<Playlist> findByTags(@Param("tags") Set<Tag> tags,
                              @Param("playlistId") Long playlistId);

}
