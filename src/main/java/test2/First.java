package test2;

import Exam.Article;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class First {

    static ArrayList<FirstArticle> firstArticles = new ArrayList<>();




    public static void main(String[] args) {

        FirstArticle a1 = new FirstArticle(1, "안녕하세요 반갑습니다. 자바 공부중이에요.","내용없음");
        FirstArticle a2 = new FirstArticle(2, "자바 질문좀 할게요~","내용없음");
        FirstArticle a3 = new FirstArticle(3, "정처기 따야되나요?","내용없음");

        firstArticles.add(a1);
        firstArticles.add(a2);
        firstArticles.add(a3);



        LocalDate now = LocalDate.now();

        Scanner scan = new Scanner(System.in);
        int lastId = 4;
        while (true) {
            System.out.println("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                System.out.println("게시물 제목을 입력해주세요.");
                String title = scan.nextLine();
                System.out.println("게시물 내용을 입력해주세요.");
                String content = scan.nextLine();

                FirstArticle firstArticle = new FirstArticle(lastId, title, content);
                firstArticles.add(firstArticle);
                System.out.println("게시물이 등록되었습니다.");
                lastId++;
            } else if (command.equals("list")) {
                System.out.println("========");

                for (int i = 0; i < firstArticles.size(); i++) {
                    FirstArticle firstArticle = firstArticles.get(i);
                    System.out.printf("번호 : %d\n", firstArticle.getCount());
                    System.out.printf("제목 : %s\n", firstArticle.getTitle());
                    System.out.printf("내용 : %s\n", firstArticle.getContent());
                }
            } else if (command.equals("update")) {
                System.out.println("수정할 게시물 번호 : ");
                int target = Integer.parseInt(scan.nextLine());

                boolean isExist = false;

                for (int i = 0; i < firstArticles.size(); i++) {
                    FirstArticle firstArticle = firstArticles.get(i);
                    if (target == firstArticle.getCount()) {
                        System.out.println("제목 : ");
                        String newTitle = scan.nextLine();
                        System.out.println("내용 : ");
                        String newContent = scan.nextLine();

                        FirstArticle newFirstArticle = new FirstArticle(target, newTitle, newContent);
                        firstArticles.set(i, newFirstArticle);

                        System.out.println("수정이 완료되었습니다.");
                        isExist = true;
                    }
                }
                if (isExist == false) {
                    System.out.println("존재하지 않는 게시물입니다.");
                }

            } else if (command.equals("delete")) {
                System.out.println("삭제할 게시물 번호 : ");
                int target = Integer.parseInt(scan.nextLine());
                boolean isExist = false;

                for (int i = 0; i < firstArticles.size(); i++) {
                    FirstArticle firstArticle = firstArticles.get(i);

                    if (target == firstArticle.getCount()) {
                        firstArticles.remove(i);
                        System.out.printf("%d번 게시물이 삭제되었습니다.\n", target);
                        isExist = true;
                    }
                }
                if (isExist == false) {
                    System.out.println("존재하지 않는 게시물입니다.");
                }

            } else if (command.equals("detail")) {
                System.out.println("상세보기 할 게시물 : ");
                int target = Integer.parseInt(scan.nextLine());
                FirstArticle firstArticle = findById(target);

                if(firstArticle == null){
                    System.out.println("존재하지않는 게시물");
                } else {
                    System.out.printf("번호 : %d\n", firstArticle.getCount());
                    System.out.println(now);
                }

            } else if (command.equals("search")){
                System.out.println("검색 키워드를 입력해주세요 : ");
                String str = scan.nextLine();
                for(int i = 0; i < firstArticles.size();i++){
                    FirstArticle firstArticle = firstArticles.get(i);
                    String title = firstArticle.getTitle();

                    if(title.contains(str)){
                        System.out.printf("번호 : %d\n", firstArticle.getCount());
                        System.out.printf("제목 : %s\n", firstArticle.getTitle());
                        System.out.printf("등록날짜 : ");
                        System.out.println(now);

                    }
                }
            }

        }
    }

    public static FirstArticle findById(int id) {
        FirstArticle target = null;
        for (int i = 0; i < firstArticles.size(); i++) {
            FirstArticle firstArticle = firstArticles.get(i);
            if(id == firstArticle.getCount()){
                target = firstArticle;
            }
        }
        return target;

    }

}