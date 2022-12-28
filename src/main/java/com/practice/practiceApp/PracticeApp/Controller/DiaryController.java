package com.practice.practiceApp.PracticeApp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.practiceApp.PracticeApp.Entity.Diary;
import com.practice.practiceApp.PracticeApp.Request.DiaryRequest;
import com.practice.practiceApp.PracticeApp.Servie.DiaryService;

@Controller
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    /*
     * 初期表示
     * 学習日記一覧画面
     * @return diary/list
     */
    @GetMapping("/diary")
    public String showTopPage(Model model) {
        List<Diary> list = diaryService.listAll();
        model.addAttribute("diaryList", list);
        return "diary/list";
    }

    /*
     * 日記登録
     * 登録画面初期表示
     * @return diary/register
     */
    @GetMapping("/diary/register")
    public String registDiary(Model model) {
        model.addAttribute("diaryRequest", new DiaryRequest());
        return "/diary/register";
    }

    /*
     * 日記登録完了
     * 学習日記登録画面
     * @return diary/register
     */
    @PostMapping("/diary/confirm")
    public String registDiary(@Validated @ModelAttribute DiaryRequest request, BindingResult bindingResult, Model model) {

        // エラーチェック
        if (bindingResult.hasErrors()) {
            List<String> errorList = new ArrayList<String>();

            for(ObjectError error : bindingResult.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            // 発生したすべてのエラーを画面に表示する
            model.addAttribute("errorList", errorList);
            return "diary/register";
        }

        // エラーがなければ登録
        diaryService.saveDiary(request);
        return "redirect:/diary";

    }
}
