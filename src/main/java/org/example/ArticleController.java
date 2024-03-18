package org.example;

import java.util.Scanner;
import java.util.ArrayList;
public class ArticleController {

    Scanner scan = new Scanner(System.in);
        ArticleManager articleManager = new ArticleManager();

    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String detail = scan.nextLine();
        articleManager.addArticle(title, detail);
        System.out.println("게시물이 등록되었습니다.");

    }

    public void list() {
        articleManager.listArticles();
    }

    public void detail() {
        System.out.print("상세보기 할 게시물 번호를 입력하세요: ");
        int index = scan.nextInt();
        scan.nextLine(); // 개행문자 제거
        articleManager.detailArticle(index - 1);

        while(true) {

            System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
            int detailmenu_num = scan.nextInt();
            scan.nextLine(); // 개행문자 제거
            articleManager.detailMenu(detailmenu_num);

            if (detailmenu_num == 5) {
                break;
            }

        }
    }

    public void update () { // 게시물 번호 입력하여 제목 및 내용 수정 진행하는 코드

        System.out.print("수정할 게시물 번호를 입력해주세요. : ");
        int index = scan.nextInt();
        scan.nextLine();

        if(articleManager.validIndex(index - 1)){
            System.out.print("제목 : ");
            String title = scan.nextLine();

            System.out.print("내용 : ");
            String detail = scan.nextLine();

            articleManager.updateArticle(index - 1, title, detail);
        } else {
            System.out.println("없는 게시물 번호 입니다.");
        }

    }

    public void delete() {

        System.out.print("삭제할 게시물 번호를 입력해주세요. : ");
        int index = scan.nextInt();
        scan.nextLine();

        if(articleManager.validIndex(index - 1)){
            articleManager.deleteArticle(index - 1);
        } else {
            System.out.println("없는 게시물 번호 입니다.");
        }
    }

    public void search() {

        System.out.print("검색할 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();
        articleManager.searchArticle(keyword);

    }
}
