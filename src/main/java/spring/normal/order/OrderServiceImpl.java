package spring.normal.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import spring.normal.annotation.MainDiscountPolicy;
import spring.normal.discount.DiscountPolicy;
import spring.normal.discount.FixDiscountPolicy;
import spring.normal.member.Member;
import spring.normal.member.MemberRepository;
import spring.normal.member.MemoryMemberRepository;

import java.util.Optional;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //필드주입
//    @Autowired
//    private MemberRepository memberRepository;
//    @Autowired
//    private DiscountPolicy discountPolicy;


    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

//중요! 생성자가 딱 1개만 있으면 @Autowired를 생략해도 자동 주입 된다. - 생성자 주입
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //수정자 자동 주입
    @Autowired
    public DiscountPolicy setDiscountPolicy(@MainDiscountPolicy DiscountPolicy discountPolicy) {
        return discountPolicy;
    }


    @Autowired(required = false)
    public void setNoBean1(Member member) {
        System.out.println("setNoBean1 = " + member);
    }

    @Autowired
    public void setNoBean2(@Nullable Member member) {
        System.out.println("setNoBean2 = " + member);
    }

    //Optional.empty 호출
    @Autowired
    public void setNoBean3(Optional<Member> member) {
        System.out.println("setNoBean3 = " + member);
    }


   //주문을 리턴
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
