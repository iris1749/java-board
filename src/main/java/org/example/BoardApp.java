package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {
    public void run() {
        Scanner scan = new Scanner(System.in);

        // 변수에는 하나의 값만 저장 가능하므로 여러개의 게시물을 저장하려면 ArryList를 사용한다.
        ArrayList<String> titlelist = new ArrayList<>();
        ArrayList<String> detaillist = new ArrayList<>();
        int update_num = 0;
        int delete_num = 0;
        int detail_num = 0;

//        String title = ""; //반복문에 변수를 저장해도 초기값으로 루프 하기때문에 밖에 저장한다.
//        String detail = ""; // 딱히 값을 지정할 필요가 없음.

        // 반복 횟수를 정할 수 없다. => 무한 반복 구조

        while(true) { // 반복 조건이 true일대 무한 반복함.

            System.out.printf("명령어 : ");
            String cmd = scan.nextLine();

            if(cmd.equals("exit")) { // 숫자가 아닌 경우 같다라는 표현을 할 때 == 이 아닌 .equals()를 사용해야 한다.
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 탈출

            } else if (cmd.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();
                titlelist.add(title);

                System.out.print("게시물 내용을 입력해주세요 : ");
                String detail = scan.nextLine();
                detaillist.add(detail);

                System.out.println("게시물이 등록되었습니다.");
            } else if(cmd.equals("list")) {
                System.out.println("==================");
                for(int i = 0; i < titlelist.size(); i++) {
                    String title = titlelist.get(i);
                    System.out.printf("제목 : %s\n", title);

//                    요구사항 6번에 따른 수정, 주석 처리
//                    String detail = detaillist.get(i);
//                    System.out.printf("내용 : %s\n", detail);
//                    System.out.println("==================");
                }

            } else if(cmd.equals("update")) {

                System.out.print("수정할 게시물 번호 : ");
                update_num = scan.nextInt();
                scan.nextLine();

                // 입력번호를 인덱스로 변환 => gpt 사용
                update_num = update_num -1;

                if(update_num > titlelist.size() || update_num < 0) {
                    System.out.println("없는 게시물 번호 입니다.");
                    System.out.println("==================");

                } else {
                    System.out.printf("수정할 게시물 번호 : %d\n", update_num + 1);

//                    기존에 내가 짠 코드
//                    System.out.print("제목 : ");
//                    String update_title = scan.nextLine();
//                    titlelist.add(titlelist.get(update_num));

//                    System.out.print("내용 : ");
//                    String update_detail = scan.nextLine();
//                    detaillist.add(titlelist.get(update_num));

                    System.out.print("제목 : ");
                    String update_title = scan.nextLine();
                    titlelist.set(update_num, update_title);

                    System.out.print("내용 : ");
                    String update_detail = scan.nextLine();
                    detaillist.set(update_num, update_detail);

                    System.out.printf("%d번 게시물이 수정되었습니다.\n", update_num + 1);
                    System.out.println("==================");
                }
            } else if(cmd.equals("delete")) {

                System.out.print("삭제할 게시물 번호 : ");
                delete_num = scan.nextInt();
                scan.nextLine();

                // 입력번호를 인덱스로 변환 => gpt 사용
                delete_num = delete_num -1;

                if(delete_num >= titlelist.size() || delete_num < 0) {
                    System.out.println("없는 게시물 번호 입니다.");
                    System.out.println("==================");

                } else {
                    System.out.printf("삭제할 게시물 번호 : %d\n", delete_num + 1);

//                    내가 짠 코드
//                    String delete_title = scan.nextLine();
//                    titlelist.remove(delete_title);
//
//                    String delete_detail = scan.nextLine();
//                    detaillist.remove(delete_detail);

                    titlelist.remove(delete_num);
                    detaillist.remove(delete_num);

                    System.out.printf("%d번 게시물이 삭제되었습니다.\n", delete_num + 1);
                    System.out.println("==================");
                }
            } else if(cmd.equals("detail")) {

                System.out.print("상세보기 할 게시물 번호를 입력해주세요. : ");
                detail_num = scan.nextInt();
                scan.nextLine();

                // 입력번호를 인덱스로 변환 => gpt 사용
                detail_num = detail_num -1;

                if(delete_num >= titlelist.size() || delete_num < 0) {
                    System.out.println("없는 게시물 번호 입니다.");
                    System.out.println("==================");

                } else {
                    System.out.printf("삭제할 게시물 번호 : %d\n", delete_num + 1);

//                    내가 짠 코드
//                    String delete_title = scan.nextLine();
//                    titlelist.remove(delete_title);
//
//                    String delete_detail = scan.nextLine();
//                    detaillist.remove(delete_detail);

                    titlelist.remove(delete_num);
                    detaillist.remove(delete_num);

                    System.out.printf("%d번 게시물이 삭제되었습니다.\n", delete_num + 1);
                    System.out.println("==================");
                }

    }
}
