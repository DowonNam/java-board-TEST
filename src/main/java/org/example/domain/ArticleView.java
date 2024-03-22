package org.example.domain;

import java.util.ArrayList;

public class ArticleView {
    public void printList(ArrayList<Article> targetList) {

        for (int i = 0; i < targetList.size(); i++) {
            System.out.println("==================");
            Article article = targetList.get(i);
            System.out.println("번호 : " + article.getId());
            System.out.println("제목 : " + article.getTitle());
            System.out.println("==================");
        }
    }

    public void printDetail(Article article) {
        System.out.println("==================");
        System.out.println("번호 : " + article.getId());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getBody());
        System.out.println("==================");
    }
}
