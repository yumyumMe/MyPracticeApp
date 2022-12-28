package com.practice.practiceApp.PracticeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.practiceApp.PracticeApp.Entity.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {
    
}
