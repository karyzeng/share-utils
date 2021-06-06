package com.zzp.array.template.sort.test;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @Description TODO
 * @Author Garyzeng
 * @since 2021.05.04
 **/
public class ArrayTemplateSortTest {

    public static void main(String[] args) {
        List<Node> templateArray = initTemplateArray();
        List<Node> newArray = initNewArray();
        System.out.println("end");
    }


    public static List<Node> initTemplateArray() {
        String json = "[{\"name\":\"id\"},{\"name\":\"name\"},{\"name\":\"expensesName\"},{\"name\":\"age\"},{\"name\":\"price\"},{\"name\":\"customer\"},{\"name\":\"remark\"}]";
        List<Node> nodes = JSON.parseArray(json, Node.class);
        return nodes;
    }

    public static List<Node> initNewArray() {
        String json = "[{\"name\":\"id\"},{\"name\":\"price\"},{\"name\":\"name\"},{\"name\":\"payment\"},{\"name\":\"expensesName\"},{\"name\":\"age\"},{\"name\":\"customer\"},{\"name\":\"remark\"}]\n";
        List<Node> nodes = JSON.parseArray(json, Node.class);
        return nodes;
    }

    private static class Node{
        private String name;

        private Integer width;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }
    }

}
