package com.team8.project2.domain.curation.curation.repository;

import com.team8.project2.domain.curation.curation.entity.CurationLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 큐레이션과 링크 간의 관계를 관리하는 데이터 접근 레포지토리 인터페이스입니다.
 */
@Repository
public interface CurationLinkRepository extends JpaRepository<CurationLink, Long> {

    /**
     * 특정 큐레이션 ID에 해당하는 모든 링크 연관 데이터를 삭제합니다.
     * @param curationId 삭제할 큐레이션의 ID
     */
    void deleteByCurationId(Long curationId);
}