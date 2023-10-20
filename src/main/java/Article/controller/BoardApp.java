package Article.controller;

import Article.model.Article;
import Article.model.ArticleRepository;
import Article.view.ArticleView;
import util.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {



  public void start() {

    ArticleView articleview = new ArticleView();




    Scanner sc = new Scanner(System.in);

    int lastId = 4;

    while (true) {
      System.out.println("명령어를 입력해주세요 : ");
      String cmd = sc.nextLine();
      if (cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      } else if (cmd.equals("add")) {
        System.out.println("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.println("게시물 내용을 입력해주세요 : ");
        String content = sc.nextLine();


        Article article = new Article(lastId, title, content, getCurrentDay());
        articles.add(article);
        System.out.println("게시물이 등록되었습니다.");
        lastId++;
      } else if (cmd.equals("list")) {

        articleview.printArticles(articles);
      } else if (cmd.equals("update")) {
        System.out.println("수정할 게시물 번호 : ");
        int targetId = Integer.parseInt(sc.nextLine());

        Article article = findBy(targetId);
        if (article == null) {
          System.out.println("없는 게시물 입니다.");
        } else {
          System.out.println("제목 : ");
          String newTitle = sc.nextLine();
          System.out.println("내용 : ");
          String newContent = sc.nextLine();
          article.setTitle(newTitle);
          article.setContent(newContent);
        }
        System.out.println("수정이 완료되었습니다.");

      } else if (cmd.equals("delete")) {
        System.out.println("삭제할 게시물 번호 : ");
        int targetId = Integer.parseInt(sc.nextLine());
        Article article = findBy(targetId);
        if (article == null) {
          System.out.println("없는 게시물 입니다.");
        } else {
          articles.remove(article);
        }
      } else if (cmd.equals("detail")) {
        System.out.println("상세보기 할 게시물 번호 : ");
        int targetId = Integer.parseInt(sc.nextLine());
        Article article = findBy(targetId);
        System.out.println("================");
        if (article == null) {
          System.out.println("존재하지 않는 게시물입니다.");

        } else {
          article.setHit(article.getHit() + 1);
          articleview.printArticleDetail(article);
        }
      } else if (cmd.equals("search")) {
        System.out.println("검색 키워드를 입력해주세요 : ");
        String keyword = sc.nextLine();

        System.out.println("===================");

        printArticles(searchedArticles); // 위에서 만들어진 ArrayList에 printArticles 함수 호출
      }
    }

  }



  public static String getCurrentDay() {
    LocalDateTime now = LocalDateTime.now(); // 현재날짜
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"); // 포맷 정의
    String formatNow = now.format(formatter); // 포맷 적용
    return formatNow;
  }
  public void printArticles(ArrayList<Article> list) { // 게시물 목록이 중복되므로 , 게시물 목록이 저장되어있는 ArrayList<Article> 가 필요
    for (int i = 0; i < list.size(); i++) {
      Article article = list.get(i);
      System.out.printf("번호 : %d\n", article.getId());
      System.out.printf("제목 : %s\n", article.getTitle());
      System.out.printf("등록날짜 : %s\n", article.getDate());
    }
  }


}


