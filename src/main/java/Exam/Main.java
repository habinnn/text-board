package Exam;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;


public class Main {

    static ArrayList<Article> articles = new ArrayList<>();

    static ArrayList<Comment> comments = new ArrayList<>();

    static ArrayList<Member> members = new ArrayList<>();

    public static void main(String[] args) {

        // 이름 짓는 규칙
        // 변수, 클래스 -> 명사
        // 함수 -> 동사
        // 단어 조합시 단어 의미가 바뀔 때마다 대문자 표현
        //       -> 카멜 표기법
        // 클래스 이름 지을 때는 첫글자 무조건 대문자.
        // 누가 봐도, 추측 가능한 단어 조합
        // 파파고나 구글 번역기, 챗 gpt 켜서
        // 이름 짓는 건 너무너무너무 중요

        // 코드 정렬
        // Alt + Ctrl + L (심심할 때마다 누르기)

        Scanner scan = new Scanner(System.in);


        int lastArticleId = 1;

        Article article1 = new Article(lastArticleId, "안녕하세요 반갑습니다. 자바 공부중이예요", "");
        articles.add(article1);
        lastArticleId++;

        Article article2 = new Article(lastArticleId, "자바 질문좀 할게요~", "");
        articles.add(article2);
        lastArticleId++;

        Article article3 = new Article(lastArticleId, "정처기 따야되나요?", "");
        articles.add(article3);
        lastArticleId++;


        while (true) {
            System.out.println("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                System.out.println("게시물 제목을 입력해주세요 : ");

                String title = scan.nextLine();

                System.out.println("게시물 내용을 입력해주세요 : ");

                String content = scan.nextLine();


                Article article = new Article(lastArticleId, title, content);
                articles.add(article);
                System.out.println("게시물이 등록되었습니다.");
                lastArticleId++;


            } else if (command.equals("list")) {
                System.out.printf("=============");

                for (int i = 0; i < articles.size(); i++) {

                    Article article = articles.get(i);

                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.printf("내용 : %s\n", article.getContent());
                    System.out.println("=============");

                }

            } else if (command.equals("update")) {
                System.out.println("수정할 게시물 번호 : ");
                int target = Integer.parseInt(scan.nextLine());


                System.out.println("제목 : ");
                String newTitle = scan.nextLine();


                System.out.println("내용 : ");
                String newContent = scan.nextLine();


                Article newArticle = new Article(lastArticleId, newTitle, newContent);
                articles.set(target - 1, newArticle);

                System.out.println("수정이 완료되었습니다.");


            } else if (command.equals("delete")) {
                System.out.println("삭제할 게시물 번호 : ");
                int target = Integer.parseInt(scan.nextLine());

                scan.nextLine();

                // target -> 내가 찾고자 하는 게시물 번호 1
                // 게시물이 10개, 10
                // ArrayList 는 0 부터 시작 예를들어 내가 게시물 1번을 지우고 싶다. target = 1 ArrayList 는 0 부터 시작하므로 target에 - 1 을 해주어야 한다.
                // 내가 가지고 있는 데이터의 개수 -1 보다 크면 안됨
                if (0 < target && target <= articles.size()) {
                    articles.remove(target - 1);
                }


                System.out.printf("%d번 게시물이 삭제되었습니다.\n", target);
            } else if (command.equals("detail")) {
                System.out.println("상세보기 할 게시물 번호 : ");


                int targetId = Integer.parseInt(scan.nextLine());
                Article article = findById(targetId);

                Date now = new Date();
                String nowTime = now.toString();
                article.increaseCount();


                if (article == null) {
                    System.out.println("존재하지 않는 게시물입니다.");
                } else {


                    System.out.println("=============");
                    System.out.printf("======" + "%d번 게시물\n" + "===", article.getId());
                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.printf("내용 : %s\n", article.getContent());
                    System.out.println(nowTime);
                    System.out.println("조회수 : " + article.getCount());
                    System.out.println("===============");
                    System.out.println("====== 댓글 ======");
                    for (int i = 0; i < comments.size(); i++) {
                        Comment comment = comments.get(i);
                        System.out.printf("댓글 내용 : %s\n", comment.getReply());
                    }
                    System.out.println("상세보기 기능을 선택해주세요");
                    System.out.printf("0.댓글 등록 ");
                    System.out.printf("1.추천 ");
                    System.out.printf("2.수정 ");
                    System.out.printf("3.삭제 ");
                    System.out.printf("4.목록으로 : ");

                    int choice = Integer.parseInt(scan.nextLine());

                    if (choice == 0) {

                        System.out.println("댓글 등록 : ");
                        String reply = scan.nextLine();
                        Comment comment = new Comment(reply);
                        System.out.println(comment.getReply());
                        comments.add(comment);
                        System.out.println("게시물이 등록되었습니다.");
                    } else if (choice == 1) {
                        System.out.println("[추천 기능] ");
                    } else if (choice == 2) {
                        System.out.println("[수정 기능]");
                    } else if (choice == 3) {
                        System.out.println("[삭제 기능]");
                    } else {
                        System.out.println("상세보기 화면을 빠져나갑니다.");
                    }


                }


            } else if (command.equals("search")) {
                Date now = new Date();
                String nowTime = now.toString();


                System.out.println("검색 키워드를 입력해주세요 : ");
                String target = scan.nextLine();

                System.out.println("==================");
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    String title = article.getTitle();

                    if (title.contains(target)) {
                        System.out.printf("번호 : %d\n", article.getId());
                        System.out.printf("제목 : %s\n", article.getTitle());
                        System.out.println(nowTime);
                        System.out.println("==================");
                    }
                }


            } else if (command.equals("signup")) {
                System.out.println("=== 회원가입을 진행합니다 ===");

                System.out.println("아이디를 입력해주세요 : ");
                String inputId = scan.nextLine();

                System.out.println("비밀번호를 입력해주세요 : ");
                String inputPassword = scan.nextLine();

                System.out.println("닉네임을 입력해주세요 : ");
                String inputNickname = scan.nextLine();

                System.out.println("=== 회원가입이 완료되었습니다. ===");

                Member member = new Member(inputId, inputPassword, inputNickname);
                members.add(member);
            } else if (command.equals("login")) {
                System.out.println("아이디를 입력해 주세요 : ");
                String inputId = scan.nextLine();

                System.out.println("비밀번호를 입력해주세요 : ");
                String inputPassword = scan.nextLine();

                boolean loggedIn = false;
                for (int i = 0; i < members.size(); i++) {
                    Member member = members.get(i);
                    if (member.getMemberId().equals(inputId) && member.getMemberPassword().equals(inputPassword)) {
                        loggedIn = true;
                        System.out.println("로그인 성공");

                    } else {
                        System.out.println("로그인 실패");
                    }


                }

            }

        }
    }

    public static Article findById(int id) {

        Article target = null;

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
            }
        }

        return target;

    }
}