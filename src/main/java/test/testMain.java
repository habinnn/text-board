package test;

import java.util.ArrayList;
import java.util.Scanner;

public class testMain {

    // 저장소 만드는 작업
    static ArrayList<testArticle> testArticles = new ArrayList<>(); // 저장소 생성


    public static void main(String[] args) {

        int tAcount = 1;


        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else if (command.equals("add")) {
                System.out.println("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();
                System.out.println("게시물 내용을 입력해주세요 : ");
                String content = scan.nextLine();

                testArticle tA = new testArticle(tAcount, title, content);
                testArticles.add(tA);
                System.out.println("게시물이 등록되었습니다.");
                tAcount++;


            } else if (command.equals("list")) {
                for (int i = 0; i < testArticles.size(); i++) {
                    testArticle tA = testArticles.get(i); // 조회

                    System.out.println("========================");
                    System.out.printf("번호 : %d\n", tA.getCount());
                    System.out.printf("제목 : %s\n", tA.getTitle());


                }


            } else if (command.equals("update")) {
                System.out.println("수정할 게시물 번호 : ");
                boolean isExist = false;
                int targetTAcount = Integer.parseInt(scan.nextLine());

                for (int i = 0; i < testArticles.size(); i++) {
                    testArticle tA = testArticles.get(i);


                    if (targetTAcount == tA.getCount()) {
                        System.out.println("제목 : ");
                        String newTitle = scan.nextLine();

                        System.out.println("내용 : ");
                        String newContent = scan.nextLine();

                        testArticle newTA = new testArticle(tAcount, newTitle, newContent);
                        testArticles.set(i, newTA);
                        System.out.println("수정이 완료되었습니다.");
                        isExist = true;
                    }
                }
                if (isExist == false) {
                    System.out.println("없는 게시물입니다.");
                }

            } else if (command.equals("delete")) {
                System.out.println("삭제할 게시물 번호 : ");
                int target = Integer.parseInt(scan.nextLine());


                if (target <= testArticles.size()) { // 범위
                    testArticles.remove(target - 1);
                }
                System.out.printf("%d번 게시물이 삭제되었습니다.", target);
            } else if (command.equals("detail")) {
                System.out.println("상세보기 할 게시물 번호를 입력해 주세요 : ");
                int targetId = Integer.parseInt(scan.nextLine());
                testArticle tA = findById(targetId);
                if (tA == null) {
                    System.out.println("존재하지 않는 게시물 번호입니다");
                } else {
                    System.out.printf("번호 : %d\n", tA.getCount());
                    System.out.printf("제목 : %s\n", tA.getTitle());
                    System.out.printf("내용 : %s\n", tA.getContent());
                }
            }
        }
    }


    // 안보고 다시
// detail 부분
// 이해하려 하지말고 외우기
    public static testArticle findById(int id) {
        testArticle target = null;
        for (int i = 0; i < testArticles.size(); i++) {
            testArticle tA = testArticles.get(i);
            if (tA.getCount() == id) {
                target = tA;
            }
        }
        return target;
    }
}



