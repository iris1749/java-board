package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {
    public void run() {
        Scanner scan = new Scanner(System.in);

        // 변수에는 하나의 값만 저장 가능하므로 여러개의 게시물을 저장하려면 ArryList를 사용한다.
        ArrayList<String> titlelist = new ArrayList<>();
        ArrayList<String> detaillist = new ArrayList<>();

//        // 검색을 위한 변수 추가
//        ArrayList<String> search_keyword = new ArrayList<>();

        // 시간 출력을 위한 변수 추가
        ArrayList<LocalDateTime> timestampList = new ArrayList<>();

        // add 명령어를 사용하여 테스트 데이터 추가
        titlelist.add("안녕하세요 반갑습니다. 자바 공부중이에요.");
        detaillist.add("");
        timestampList.add(LocalDateTime.now());

        titlelist.add("자바 질문좀 할게요");
        detaillist.add("");
        timestampList.add(LocalDateTime.now());

        titlelist.add("정처기 따야되나요?");
        detaillist.add("");
        timestampList.add(LocalDateTime.now());

        // 사용변수 정의
        int update_num = 0;
        int delete_num = 0;
        int detail_num = 0;
        String search_keyword;


//        String title = ""; //반복문에 변수를 저장해도 초기값으로 루프 하기때문에 밖에 저장한다.
//        String detail = ""; // 딱히 값을 지정할 필요가 없음.

        // 반복 횟수를 정할 수 없다. => 무한 반복 구조

        while(true) { // 반복 조건이 true일대 무한 반복함.

            System.out.printf("명령어 : ");
            String cmd = scan.nextLine();

            if(cmd.equals("exit")) { // 숫자가 아닌 경우 같다라는 표현을 할 때 == 이 아닌 .equals()를 사용해야 한다.
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 탈출

            } else if (cmd.equals("add")) { // 게시물 제목 내용 등록 코드
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();
                titlelist.add(title);

                System.out.print("게시물 내용을 입력해주세요 : ");
                String detail = scan.nextLine();
                detaillist.add(detail);

                // 현재 시간을 기록 use chatgpt
                LocalDateTime timestamp = LocalDateTime.now();
                timestampList.add(timestamp);

                System.out.println("게시물이 등록되었습니다.");
            } else if(cmd.equals("list")) {
                System.out.println("==================");
                for(int i = 0; i < titlelist.size(); i++) {
                    String title = titlelist.get(i);
                    System.out.printf("번호 : %d\n", i + 1);
                    System.out.printf("제목 : %s\n", title);
                    System.out.println("==================");

//                    요구사항 6번에 따른 수정, 주석 처리
//                    String detail = detaillist.get(i);
//                    System.out.printf("내용 : %s\n", detail);
//                    System.out.println("==================");
                }

            } else if(cmd.equals("update")) { // 게시물 번호 입력하여 제목 및 내용 수정 진행하는 코드

                System.out.print("수정할 게시물 번호를 입력해주세요. : ");
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

                    // 현재 수정된 시간을 기록 use chatgpt
                    LocalDateTime timestamp = LocalDateTime.now();
                    timestampList.add(timestamp);
                }
            } else if(cmd.equals("delete")) { // 번호별 게시물 삭제 기능 코드

                System.out.print("삭제할 게시물 번호를 입력해주세요. : ");
                delete_num = scan.nextInt();
                scan.nextLine();

                // 입력번호를 인덱스로 변환 use chatgpt
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
            } else if(cmd.equals("detail")) { // 번호별 제목 내용 등록일자 출력 코드

                System.out.print("상세보기 할 게시물 번호를 입력해주세요. : ");
                detail_num = scan.nextInt();
                scan.nextLine();

                // 입력번호를 인덱스로 변환 => use chatgpt
                detail_num = detail_num - 1;

                if (detail_num >= titlelist.size() || detail_num < 0) {
                    System.out.println("존재하지 않는 게시물 번호 입니다.");

                } else {
                    System.out.printf("상세보기 할 게시물 번호 : %d\n", detail_num + 1);

                    System.out.println("==================");
                    System.out.printf("번호 : %s\n", detail_num + 1);

                    String title = titlelist.get(detail_num);
                    System.out.printf("제목 : %s\n", title);

                    String detail = detaillist.get(detail_num);
                    System.out.printf("내용 : %s\n", detail);

                    LocalDateTime timestamp = timestampList.get(detail_num);
                    // 등록한 시간을 원하는 형식으로 출력
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String formattedTimestamp = timestamp.format(formatter);
                    System.out.printf("등록 날짜 : %s\n", formattedTimestamp);

                    System.out.println("==================");

                }
            } else if (cmd.equals("search")) { //구문 전체 구현 use chatgpt
                System.out.print("검색할 키워드를 입력해주세요 : ");
                String keyword = scan.nextLine();

                // 검색 결과를 표시하기 위한 변수 use chatgpt
                boolean search = false;

                for (int i = 0; i < titlelist.size(); i++) {
                    String title = titlelist.get(i);
                    String detail = detaillist.get(i);

                    if(title.contains(keyword) || detail.contains(keyword)) {
                        // 검색 결과가 있음.
                        search = true;

                        System.out.println("==================");
//                        System.out.printf("검색된 게시물 번호: %d\n", i + 1);
                        System.out.printf("번호 : %d\n", i + 1);
                        System.out.printf("제목 : %s\n", title);
                        System.out.println("==================");

                    }
                }

                if (!search) {
                    System.out.println("검색 결과가 없습니다.");
                }

            }

        }

    }
}
