package test2;

import java.util.ArrayList;
import java.util.Scanner;

public class First {

    static ArrayList<FirstArticle> firstArticles = new ArrayList<>();

    // 한건만 저장

    public static void main(String[] args) {
        String title = "";
        String content = "";

        Scanner scan = new Scanner(System.in); // 1. 스캐너
        System.out.println("명령어 : ");
        String command = scan.nextLine();

        if (command.equals("exit")) {
            System.out.println("프로그램을 종료합니다");
            break;
        } else if (command.equals("add")) {
            while (true) { // 2. while 문

                System.out.println("게시물 제목 : ");

                title = scan.nextLine();

                System.out.println("게시물 내용 : ");

                content = scan.nextLine();

                FirstArticle firstArticle = new FirstArticle(title, content);
                firstArticles.add(firstArticle);
                System.out.println("게시물 등록 완료");
            } else if (command.equals("list")) {

                System.out.printf("제목 : %s\n", title);
                System.out.printf("내용 : %s\n", content);
                System.out.println("===========");
            }
        }
    }

}

