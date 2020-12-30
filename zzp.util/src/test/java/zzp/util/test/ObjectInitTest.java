package zzp.util.test;

/**
 * @Description 测试初始化
 * @Author Garyzeng
 * @since 2019.09.23
 **/
public class ObjectInitTest {

    private static String author;

    private Integer version;

    private String name;

    static {
        author = "GaryZeng";
        System.out.println("执行静态初始化块，author：" + author);
    }

    {
        version = 1;
        name = "测试初始化";
        System.out.println("执行初始化块，version：" + version + "，name：" + name);
    }

    public ObjectInitTest() {
        System.out.println("执行构造方法，author：" + author + "，version：" + version + "，name：" + name);
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ObjectInitTest test = new ObjectInitTest();
    }
}
