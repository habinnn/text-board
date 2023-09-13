import javax.xml.stream.events.Comment;

public class Article {



    // 게시물 번호
    private int id;

    // 제목

    private String title ;

    // 내용
    private String content;

    private int count;








    public Article(int id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;

    }

    public void increaseCount() {
        count++;
    }


    public int getCount() {

        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
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


}
