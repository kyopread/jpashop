package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 주로 읽기 작업이 많을 때 이렇게 하고 쓰기 작업의 메서드에 한번 더 선언해준다. 기본 false 임
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     * @param member
     * @return
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 한번 더 최후의 방어 수단으로 member 의 name을 유니크 제약조건으로 남겨놓는 방법 고려.
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty())
            throw new IllegalStateException("이미 존재하는 회원입니다.");
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
