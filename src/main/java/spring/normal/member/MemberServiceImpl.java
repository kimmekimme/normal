package spring.normal.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    //멤버 찾기 키값 넣으면 멤버 나옴
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
