package com.practice.practiceApp.PracticeApp.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryRequest {
    
    @NotBlank(message = "タイトルは必須です")
    @Size(max = 100, message = "タイトルは100字以内で入力してください")
    private String title;

    @NotBlank(message = "内容は必須です")
    private String content;

    @NotBlank(message = "開始時刻は必須です")
    private String start_date;

    @NotBlank(message = "終了時刻は必須です")
    private String end_date;

}
