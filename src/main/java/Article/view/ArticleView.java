package test5.view;

import test5.model.Article;

import java.util.ArrayList;

public class ArticleView {
  public void printArticleDetail(Article article){
    System.out.printf("번호 : %d\n", article.getId());
    System.out.printf("제목 : %s\n", article.getTitle());
    System.out.printf("내용 : %s\n", article.getContent());
    System.out.printf("조회수 : %d\n", article.getHit());
    System.out.printf("등록일 : %s\n", article.getDate());
    System.out.println("================");
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
