package hello.hellospring.domain;

import hello.hellospring.repository.MemberRepository;

import java.util.List;

public class Member implements MemberRepository {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
