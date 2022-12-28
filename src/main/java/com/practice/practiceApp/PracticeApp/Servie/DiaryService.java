package com.practice.practiceApp.PracticeApp.Servie;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.practiceApp.PracticeApp.Entity.Diary;
import com.practice.practiceApp.PracticeApp.Repository.DiaryRepository;
import com.practice.practiceApp.PracticeApp.Request.DiaryRequest;

@Service
public class DiaryService {

    @Autowired
    DiaryRepository diaryRepositry;

    /*
     * 学習日記一覧取得
     */
    public List<Diary> listAll() {
        List<Diary> list = diaryRepositry.findAll();
        return list;
    }

    /*
     * 学習日記登録
     */
    public void saveDiary(DiaryRequest request) {

        // エンティティに詰めなおす
        Diary diary = new Diary();
        diary.setTitle(request.getTitle());
        diary.setContent(request.getContent());
        diary.setStart_date(request.getStart_date());
        diary.setEnd_date(request.getEnd_date());

        diaryRepositry.save(diary);
    }
    
}
