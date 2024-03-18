package org.example;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArticleView {
    public void printArticlelist() {
            System.out.println("==================");
            for (int i = 0; i < titleList.size(); i++) {
                System.out.printf("번호: %d\n", i + 1);
                System.out.printf("제목: %s\n", titleList.get(i));
                System.out.println("==================");
            }
    }

    public void printArticleDetail() {
        if (validIndex(index)) {
            System.out.printf("=== %d번 게시물 ===\n", index +1);
            System.out.printf("번호: %d\n", index + 1);
            System.out.printf("제목: %s\n", titleList.get(index));
            System.out.printf("내용: %s\n", detailList.get(index));
            System.out.printf("등록 날짜: %s\n", timestampList.get(index).format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss")));
            System.out.printf("조회수: %d\n", viewCounts.get(index));
            System.out.println("==================");

            // 조회수 증가
            int count = viewCounts.get(index) + 1;
            viewCounts.set(index, count);

        } else {
            System.out.println("없는 게시물 번호 입니다.");
        }
    }
}
