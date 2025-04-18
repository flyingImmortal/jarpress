package cn.seifly.module.wp.comm;

public enum PostTypeEnum {
    CATEGORY("category", "分类"), POST_TAG("post_tag", "标签");
    private String name;
    private String describe;

    private PostTypeEnum(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}
