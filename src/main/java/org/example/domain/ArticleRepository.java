package org.example.domain;

import org.example.base.CommonUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleRepository {
    CommonUtil commonUtil = new CommonUtil();
    ArrayList<Article> articleList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    int latestId = 1;

    public ArrayList<Article> findKeywordArticle(String keyword) {
        ArrayList<Article> searchedList = new ArrayList<>();

        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            if(article.getTitle().contains(keyword)){
                searchedList.add(article);
            }
        }
        return searchedList;
    }
    public Article findID(int input){
        for(int i = 0; i < articleList.size(); i++){
            Article article = articleList.get(i);
            if(article.getId() == input){
                return article;
            }
        } return null;
    }
    public void deleteArticle(Article article){
        articleList.remove(article);
    }
    public void updateArticle(Article article, String NewTitle, String NewBody){
        article.setTitle(NewTitle);
        article.setBody(NewBody);
    }
    public ArrayList<Article> findAll(){
        return articleList;
    }

    public Article saveArticle(String title, String body){
        Article article = new Article(latestId,title,body,0, commonUtil.CurrentDateTime());
        articleList.add(article);
        latestId++;

        return article;
    }
}