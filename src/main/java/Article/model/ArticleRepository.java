package test5.model;

import java.util.ArrayList;

public class ArticleRepository {
  ArrayList<Article> articles = new ArrayList<>();
  public ArticleRepository(){
  Article a1 = new Article(1, "hi", "bye", getCurrentDay());
  Article a2 = new Article(2, "hi2", "bye2", getCurrentDay());
  Article a3 = new Article(3, "hi3", "bye3", getCurrentDay());

    articles.add(a1);
    articles.add(a2);
    articles.add(a3);
  }

  public void insert(Article article){
    articles.add(article);
  }
  public void delete(Article article){
    articles.remove(article);
  }

  public ArrayList<Article> findAllArticles(){
    return articles;
  }
  public Article findBy(int id) {
    Article target = null;
    for (int i = 0; i < articles.size(); i++) {
      Article article = articles.get(i);
      if (id == article.getId()) {
        target = article;
      }
    }
    return target;
  }
  public ArrayList<Article> findByTitle (String keyword){
    ArrayList<Article> searchedArticles = new ArrayList<>(); // 일부분을 떼어내서 출력하기 위해 ArrayList 생성
    for (int i = 0; i < articles.size(); i++) {
      Article article = articles.get(i);
      String title = article.getTitle();
      if (title.contains(keyword)) {
        searchedArticles.add(article);
      }
    }
    return searchedArticles;
  }
}
