package org.example.domain;

import org.example.base.CommonUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    CommonUtil commonUtil = new CommonUtil();
    ArticleRepository articleRepository = new ArticleRepository();
    ArticleView articleView = new ArticleView();
    Scanner scan = commonUtil.getScan();
    int wrong_num = -1;

    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();
        ArrayList<Article> searchedList = articleRepository.findKeywordArticle(keyword);
        if(searchedList.size()==0){
            System.out.println("==================");
            System.out.println("검색 결과가 없습니다.");
        }
        articleView.printList(searchedList);
    }

    public void detail() {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int inputNum = ParamByInt(scan.nextLine(), wrong_num);
        if (inputNum == wrong_num) {
            return;
        }
        Article article = articleRepository.findID(inputNum);
        if (article == null) {
            System.out.println("존재하지 않는 게시물 번호입니다.");
            return;
        }
        article.increaseHit();
        articleView.printDetail(article);
    }

    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int inputNum = ParamByInt(scan.nextLine(), wrong_num);
        if (inputNum == wrong_num) {
            return;
        }
        Article article = articleRepository.findID(inputNum);
        articleRepository.deleteArticle(article);
        System.out.println(inputNum + "번 게시물이 삭제되었습니다.");
    }

    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        int inputNum = ParamByInt(scan.nextLine(), wrong_num);
        if (inputNum == wrong_num) {
            return;
        }
        Article article = articleRepository.findID(inputNum);
        if (article == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }
        System.out.print("제목 : ");
        String newTitle = scan.nextLine();

        System.out.print("내용 : ");
        String newBody = scan.nextLine();

        articleRepository.updateArticle(article,newTitle,newBody);
        System.out.println(inputNum + "번 게시물이 수정되었습니다.");

    }
    public void list(){
        ArrayList<Article> searchList = articleRepository.findAll();
        articleView.printList(searchList);
    }
    public void add(){
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();
        articleRepository.saveArticle(title,body);
        System.out.println("게시물이 등록되었습니다.");
    }

    private int ParamByInt(String parma, int defaultValue) {
        try {
            return Integer.parseInt(parma);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return defaultValue;
        }
    }
}
