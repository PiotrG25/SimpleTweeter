package pl.coderslab.modelDto;

public class SimpleUser{
    private Long id;
    private String name;
    public SimpleUser(Long id, String name){
        this.id = id;
        this.name = name;
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
