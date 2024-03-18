package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArticleManager {
    private ArrayList<String> titleList;
    private ArrayList<String> detailList;
    private ArrayList<LocalDateTime> timestampList;
    private ArrayList<Integer> viewCounts;

    boolean validIndex(int index) {
        return index >= 0 && index < titleList.size();
    }

    public ArticleManager() {

        titleList = new ArrayList<>();
        detailList = new ArrayList<>();
        timestampList = new ArrayList<>();
        viewCounts = new ArrayList<>();

        // test용 데이터 추가

        addArticle("안녕하세요 반갑습니다. 자바 공부중이에요.", "");
        addArticle("자바 질문좀 할게요~", "");
        addArticle("정처기 따야되나요?", "");
    }

    public void addArticle(String title, String detail) {

        titleList.add(title);
        detailList.add(detail);
        timestampList.add(LocalDateTime.now());
        viewCounts.add(1);
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

    public void detailArticle(int index) {


    }

    public void detailMenu(int detailmenu_num) {

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


