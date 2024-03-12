package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class ArticleManager {
    private ArrayList<String> titleList;
    private ArrayList<String> detailList;
    private ArrayList<LocalDateTime> timestampList;
    private ArrayList<Integer> viewCounts;
    private ArrayList<String> search_keyword;

    boolean validIndex(int index) {
        return index >= 0 && index < titleList.size();
    }

    public ArticleManager() {
        titleList = new ArrayList<>();
        detailList = new ArrayList<>();
        timestampList = new ArrayList<>();
        viewCounts = new ArrayList<>();
        search_keyword = new ArrayList<>();
    }

    public void addArticle(String title, String detail) {
        titleList.add(title);
        detailList.add(detail);
        timestampList.add(LocalDateTime.now());
        viewCounts.add(1);
    }

    public void listArticles() {
        System.out.println("==================");
        for (int i = 0; i < titleList.size(); i++) {
            System.out.printf("번호: %d\n", i + 1);
            System.out.printf("제목: %s\n", titleList.get(i));
            System.out.println("==================");
        }
    }

    public void updateArticle(int index, String title, String detail) {
        if (validIndex(index)) {
            titleList.set(index, title);
            detailList.set(index, detail);
            timestampList.set(index, LocalDateTime.now());
            System.out.println("게시물이 수정되었습니다.");
        }
    }

    public void deleteArticle(int index) {
        if (validIndex(index)) {
            titleList.remove(index);
            detailList.remove(index);
            timestampList.remove(index);
            viewCounts.remove(index);
            System.out.println("게시물이 삭제되었습니다.");
        }
    }

    public void viewArticleDetail(int index) {
        if (validIndex(index)) {
            System.out.println("==================");
            System.out.printf("번호 : %d\n", index + 1);
            System.out.printf("제목 : %s\n", titleList.get(index));
            System.out.printf("내용 : %s\n", detailList.get(index));
            System.out.printf("등록 날짜 : %s\n", timestampList.get(index).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            System.out.printf("조회수 : %d\n", viewCounts.get(index));

            //조회수 증가
            viewCounts.set(index, viewCounts.get(index) + 1);
        } else {
            System.out.println("없는 게시물 번호 입니다.");
        }
    }
    public void detailArticle(int index) {
        if (validIndex(index)) {
            System.out.println("==================");
            System.out.printf("번호: %d\n", index + 1);
            System.out.printf("제목: %s\n", titleList.get(index));
            System.out.printf("내용: %s\n", detailList.get(index));
            System.out.printf("등록 날짜: %s\n", timestampList.get(index).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            System.out.printf("조회수: %d\n", viewCounts.get(index));

            // 조회수 증가
            int count = viewCounts.get(index) + 1;
            viewCounts.set(index, count);

            System.out.println("==================");
        } else {
            System.out.println("없는 게시물 번호 입니다.");
        }
    }

     public void searchArticle(String keyword) {

         boolean search = false;

         for (int i = 0; i < titleList.size(); i++) {
             String title = titleList.get(i);
             String detail = detailList.get(i);

             if(title.contains(keyword) || detail.contains(keyword)) {

                 search = true;

                 System.out.println("==================");
                 System.out.printf("번호 : %d\n", i + 1);
                 System.out.printf("제목 : %s\n", title);
                 System.out.println("==================");
             }
         }

         if (!search) {
             System.out.println("==================");
             System.out.println("검색 결과가 없습니다.");
             System.out.println("==================");
         }
     }

}


