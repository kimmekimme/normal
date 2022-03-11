package spring.normal.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    //키 롱 타입, 값 멤버
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    //멤버 아이디가 키, 값은 멤버 받아서
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    //맵의 겟을 이용해서 아이디 찾아오는 메서드
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
