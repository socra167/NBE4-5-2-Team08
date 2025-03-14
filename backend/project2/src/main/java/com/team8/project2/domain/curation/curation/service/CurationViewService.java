package com.team8.project2.domain.curation.curation.service;

import com.team8.project2.domain.curation.curation.entity.Curation;
import com.team8.project2.domain.curation.curation.repository.CurationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CurationViewService {

    private final CurationRepository curationRepository;

    public CurationViewService(CurationRepository curationRepository) {
        this.curationRepository = curationRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW) // 별도 트랜잭션 실행
    public void increaseViewCount(Curation curation) {
        System.out.println("현재 조회수 (조회 전): " + curation.getViewCount());

        // 조회수 증가
        curation.increaseViewCount();

        System.out.println("조회수 증가 후: " + curation.getViewCount());

        // DB에 저장
        curationRepository.save(curation);
        curationRepository.flush(); // 즉시 반영

        System.out.println("조회수 저장 후 (DB 반영): " + curation.getViewCount());
    }
}

