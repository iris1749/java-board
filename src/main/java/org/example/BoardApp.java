package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {
    public void run() {
        Scanner scan = new Scanner(System.in);
        //chatgpt 개선 (클래스 분리)
        ArticleManager articleManager = new ArticleManager();

        while(true) { // 반복 조건이 true일대 무한 반복함.

            System.out.printf("명령어 : ");
            String cmd = scan.nextLine();

            if(cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 탈출

            } else if (cmd.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();

                System.out.print("게시물 내용을 입력해주세요 : ");
                String detail = scan.nextLine();

                articleManager.addArticle(title, detail);

                System.out.println("게시물이 등록되었습니다.");

            } else if (cmd.equals("list")) {
                articleManager.listArticles();

            } else if (cmd.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력하세요: ");
                int index = scan.nextInt();

                scan.nextLine(); // 개행문자 제거
                articleManager.detailArticle(index - 1);

            } else if(cmd.equals("update")) { // 게시물 번호 입력하여 제목 및 내용 수정 진행하는 코드

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

            } else if(cmd.equals("delete")) {

                System.out.print("삭제할 게시물 번호를 입력해주세요. : ");
                int index = scan.nextInt();
                scan.nextLine();

                if(articleManager.validIndex(index - 1)){
                    articleManager.deleteArticle(index - 1);
                } else {
                    System.out.println("없는 게시물 번호 입니다.");
                }


            } else if(cmd.equals("detail")) {

                System.out.print("상세보기 할 게시물 번호를 입력해주세요. : ");
                int index = scan.nextInt();
                scan.nextLine();

                articleManager.viewArticleDetail(index - 1);

            } else if (cmd.equals("search")) {

                System.out.print("검색할 키워드를 입력해주세요 : ");
                String keyword = scan.nextLine();
                scan.nextLine();

            }

        }

    }

}
