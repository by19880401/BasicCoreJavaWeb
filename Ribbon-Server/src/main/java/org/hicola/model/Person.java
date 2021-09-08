package org.hicola.model;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/9/2
 * @
 */
public class Person {
    private Integer id;
    private String name;
    private String url;//处理请求的服务器url
    private String message;//提示信息

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
