package test5.model;
package Article.model;

public class Article {
  private int hit;
  private int id;
  private String title;
  private String content;
  private String date;


  public Article(int id, String title, String content, String date ) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.date = date;

  }


  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }


  public void setContent(String content) {
    this.content = content;
  }


  public String getContent() {
    return content;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getHit() {
    return hit;
  }

  public void setHit(int hit) {
    this.hit = hit;
  }
}
