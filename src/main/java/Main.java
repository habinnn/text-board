import java.util.ArrayList;
import java.util.Scanner;


public class Main {
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


        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> contentList = new ArrayList<>();

        String title = "";
        String content = "";

        while (true) {
            System.out.println("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                System.out.println("게시물 제목을 입력해주세요 : ");

                titleList.add(scan.nextLine());
                System.out.println("게시물 내용을 입력해주세요 : ");

                contentList.add(scan.nextLine());
                System.out.println("게시물이 등록되었습니다.");


            } else if (command.equals("list")) {
            System.out.println("=====================");
            System.out.printf("제목 : %s\n", title);
            System.out.printf("내용 : %s\n", content);
            System.out.println("===============");
                for(int i = 0 ; i < titleList.size(); i++){
                    System.out.printf("제목 : %s\n", titleList.get(i));
                    System.out.printf("내용 : %s\n", contentList.get(i));
                    System.out.println("============");
                }
        } else if (command.equals("delete")){
                System.out.println("삭제할 게시물 번호 : ");
                int remove5 = scan.nextInt();
                if(remove5 >= 0 ){
                    titleList.remove(remove5);
                    contentList.remove(remove5);
                    System.out.println("===========");
                    System.out.println("게시물이 삭제되었습니다.");

                } else if(command.equals("update")) {
                    System.out.println("수정할 게시물 번호 : ");
                    int update = scan.
                }




                }
            }

    }

}





// 문자열 비교
//        String str = "hello";
//        System.out.println(str.equals("hello"));





